package com.ktz.deploy.jdbc.service.impl;

import com.ktz.deploy.jdbc.entity.dto.AbsDepartmetData;
import com.ktz.deploy.jdbc.entity.dto.Page;
import com.ktz.deploy.jdbc.entity.dto.ProvBase;
import com.ktz.deploy.jdbc.entity.dto.ProvTable;
import com.ktz.deploy.jdbc.enums.DepartTableEnum;
import com.ktz.deploy.jdbc.service.DepartmentDataService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName DepartmentDataServiceImpl
 * @Description 部门数据处理实现类
 * @Author kaituozhesh
 * @Date 2020/3/26 11:32
 * @Version V1.0
 **/
@Service
public class DepartmentDataServiceImpl implements DepartmentDataService {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * @param searchParsm
     * @return
     */
    @Override
    public ProvTable getList(AbsDepartmetData searchParsm) {
        // 查询参数列表
        List<ProvBase> provBases = provList(DepartTableEnum.getTableName(searchParsm.getMarketId()));
        List<String> sqlTitle = provBases.stream().map(ProvBase::getFieldName).collect(Collectors.toList());

        Map<String, Object> paramsMap = getNotNullPropertyNames2(searchParsm);
        String sql = getListSql(paramsMap, searchParsm);
        List query = jdbcTemplate.query(sql, rs -> {
            List<Map<String, Object>> result = new ArrayList<>();
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>(16);
                for (String s : sqlTitle) {
                    row.put(s, rs.getObject(s));
                }
                result.add(row);
            }
            return result;
        });
        return new ProvTable(provBases, this.getPage(query, searchParsm));
    }

    /**
     * 查询列ID对象表要查的字段名
     *
     * @param tableName
     * @return
     */
    private List<ProvBase> provList(String tableName) {
        return jdbcTemplate.queryForList("select * from prov_base where table_name = " + tableName, ProvBase.class);
    }

    @Override
    public long findCount(String talbeName) {
        return jdbcTemplate.queryForObject(getCountSql(talbeName), Long.class);
    }

    private Page getPage(List list, AbsDepartmetData searchParam) {
        Page page = new Page();
        List resultList = list;
        if (searchParam.getPageSize() > 0) {
            resultList = list.subList((searchParam.getPageNum() - 1) * searchParam.getPageSize(), searchParam.getPageSize());
        }
        page.setList(resultList);
        page.setTotal(list.size());
        page.setPageNum(searchParam.getPageNum());
        page.setPageSize(searchParam.getPageSize());
        return page;
    }


    /**
     * 获取对象中所有不为空的属性名  会获取父级属性
     *
     * @param source
     * @return
     */
    private static Map<String, Object> getNotNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Map<String, Object> paramMap = new HashMap<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (!ObjectUtils.isEmpty(srcValue)) {
                paramMap.put(pd.getName(), srcValue);
            }
        }
        paramMap.remove("class");
        paramMap.remove("marketId");
        return paramMap;
    }


    /**
     * 获取对象中所有不为空的属性名  不会获取父级的
     *
     * @param source
     * @return
     */
    private Map<String, Object> getNotNullPropertyNames2(Object source) {
        Map<String, Object> paramMap = new HashMap<>();
        // 拿到该类
        Class<?> clz = source.getClass();
        // 获取实体类的所有属性，返回Field数组
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(source);
                if (!ObjectUtils.isEmpty(value)) {
                    paramMap.put(field.getName(), value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        paramMap.remove("marketId");
        return paramMap;
    }

    /**
     * 拼接查询列表SQL
     *
     * @param paramsMap
     * @param searchParam
     * @return
     */
    private static String getListSql(Map<String, Object> paramsMap, AbsDepartmetData searchParam) {
        StringBuilder sb = new StringBuilder("select * from " + DepartTableEnum.getTableName(searchParam.getMarketId()) + " ");
        if (paramsMap != null && paramsMap.size() > 0) {
            sb.append(" where ");
            Iterator<String> iterator = paramsMap.keySet().iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                sb.append(next + " like '%" + paramsMap.get(next) + "%' ");
                if (iterator.hasNext()) {
                    sb.append("and ");
                }
            }
        }
        return sb.toString();
    }

    /**
     * 拼接查询数量接口
     *
     * @param tableName
     * @return
     */
    private static String getCountSql(String tableName) {
        return Strings.isEmpty(tableName) ? "select 0" : "select count(1) from " + tableName;
    }
}
