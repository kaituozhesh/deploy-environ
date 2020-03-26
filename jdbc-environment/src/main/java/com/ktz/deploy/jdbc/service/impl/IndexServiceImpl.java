package com.ktz.deploy.jdbc.service.impl;

import com.ktz.deploy.jdbc.entity.dto.DepartDataDto;
import com.ktz.deploy.jdbc.enums.DepartEnum;
import com.ktz.deploy.jdbc.enums.DepartTableEnum;
import com.ktz.deploy.jdbc.service.DepartmentDataService;
import com.ktz.deploy.jdbc.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IndexServiceImpl
 * @Description 首页数据统计
 * @Author kaituozhesh
 * @Date 2020/3/26 13:18
 * @Version V1.0
 **/
@Service
public class IndexServiceImpl implements IndexService {


    @Autowired
    private DepartmentDataService departmentDataService;

    /**
     * 部门数据  表格块统计信息
     *
     * @return
     */
    @Override
    public List<DepartDataDto> collectData() {
        List<DepartDataDto> list = new ArrayList<>();
        DepartEnum[] values = DepartEnum.values();
        for (int i = 0; i < values.length; i++) {
            list.add(new DepartDataDto(values[i].getId(), values[i].getUrl(), values[i].getValue(), getTotalCount(values[i])));
        }
        return list;
    }

    /**
     * 根据块枚举  ID  计算块中所有table的总数量
     *
     * @param departEnum
     * @return
     */
    private long getTotalCount(DepartEnum departEnum) {
        List<String> tableNameList = DepartTableEnum.getTableNameList(departEnum.getId());
        return tableNameList.size() > 0 ? tableNameList.stream().mapToLong(tableName -> departmentDataService.findCount(tableName)).sum() : 0;
    }

    /**
     * 查询块ID对应的 查询列表
     *
     * @param id
     * @return
     */
    @Override
    public List<DepartDataDto> tableList(String id) {
        return getTableList(id);
    }

    /**
     * 获取块对应列表
     *
     * @param id
     * @return
     */
    private List<DepartDataDto> getTableList(String id) {
        List<DepartTableEnum> tableNameList = DepartTableEnum.getTableList(id);
        List<DepartDataDto> list = new ArrayList<>();
        tableNameList.forEach(tableEnum -> list.add(new DepartDataDto(tableEnum.getId(), DepartEnum.getUrl(id), tableEnum.getName(), null)));
        return list;
    }
}
