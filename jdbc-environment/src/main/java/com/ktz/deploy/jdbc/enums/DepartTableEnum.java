package com.ktz.deploy.jdbc.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 部门数据 对应表名
 * @Author kaituozhesh
 * @Date 2020/3/26 9:51
 **/
public enum DepartTableEnum {

    B_AJ_COMPANY("12_01","b_aj_company","市安检局安全生产警示机构信息"),
    B_AJ_COMPANY_EVENT("12_02","b_aj_company_event","市安检局重大案件事故信息"),
    BB_13("13","","市兴光燃气集团"),
    B_R_COMPANY_ACCOUNT("14_01","b_rh_company_account","机构账号异动信息"),
    B_R_PEOPLE_ACCOUNT("14_02","b_rh_people_account","个人账号信息异动"),
    B_SW_COMPANY_DECISION("15_01","b_sw_company_decision","机构处罚信息"),
    B_JG_COMPANY_DECISION("20_01", "b_jg_company_decision", "机构处罚信息"),
    B_JG_COMPANY_SHAREHOLDER("20_02", "b_jg_company_shareholder", "企业股东信息"),
    B_03("20_03", "", "主要经营者管理信息"),
    B_JG_COMPANY_STAFF("20_04", "b_jg_company_staff", "企业经营失信名录信息"),
    B_JG_COMPANY_ABNORMAL("20_05", "b_jg_company_abnormal", "严重违法失信企业名录"),
    B_JG_COMPANY_LOSECREDIT("20_06", "b_jg_company_losecredit", "企业登记信息"),
    B_JG_COMPANY("20_07", "b_jg_company", "企业变更登记信息"),
    B_JG_COMPANY_CHANGE("20_08", "b_jg_company_change", "工商-股权变更信息"),
    GATEWAY_STOCK_CHANGGE("20_09", "gateway_stock_changge", "法人地址标准化信息"),
    ;

    /**
     * 交互ID
     */
    private String id;
    /**
     * 数据库对应表名
     */
    private String tableName;
    /**
     * 前端页面显示name
     */
    private String name;

    DepartTableEnum(String id, String tableName, String name) {
        this.id = id;
        this.tableName = tableName;
        this.name = name;
    }


    public String getTableName() {
        return tableName;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static String getTableName(String id) {
        DepartTableEnum[] values = DepartTableEnum.values();
        for (DepartTableEnum table : values) {
            if (table.getId().equals(id)) {
                return table.getTableName();
            }
        }
        return null;
    }

    /**
     * 根据块ID匹配  块对应的所有表名
     *
     * @param id
     * @return
     */
    public static List<String> getTableNameList(String id) {
        List<String> tableNameList = new ArrayList<>();
        DepartTableEnum[] values = DepartTableEnum.values();
        for (DepartTableEnum tableId : values) {
            if (tableId.getId().indexOf(id + "_") == 0) {
                tableNameList.add(tableId.getTableName());
            }
        }
        return tableNameList;
    }

    /**
     * 根据块ID获取所有的列表集合
     *
     * @param id
     * @return
     */
    public static List<DepartTableEnum> getTableList(String id) {
        List<DepartTableEnum> tableList = new ArrayList<>();
        DepartTableEnum[] values = DepartTableEnum.values();
        for (DepartTableEnum tableEnum : values) {
            if (tableEnum.getId().indexOf(id + "_") == 0) {
                tableList.add(tableEnum);
            }
        }
        return tableList;
    }
}
