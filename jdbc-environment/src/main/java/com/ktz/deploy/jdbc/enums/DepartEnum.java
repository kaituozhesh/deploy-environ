package com.ktz.deploy.jdbc.enums;

import com.alibaba.druid.util.StringUtils;


/**
 * @Description 部门数据 首页列表块
 * @Author kaituozhesh
 * @Date 2020/3/26 13:24
 */
public enum DepartEnum {
    ECOLOG_SUPERVISE("1", "市生态环境局", ""),
    NATURAL_RESOURCES("2", "市自然资源规划局", ""),
    BANK_SUPERVISE("3", "宁波银保监局", ""),
    CIVIL_AFFAIRS_BUREAU("4", "市民政局", ""),
    CUSTOMS_SUPERVISE("5", "宁波海关", ""),
    POLICE_SUPERVISE("6", "市公安局", ""),
    COURT_SUPERVISE("7", "市中级法院", ""),
    PEOPLE_BANK_SUPERVISE("8", "人行市中心支行", ""),
    PEOPLE_SOCIAL_SUPERVISE("9", "市人力社保局", ""),
    REVENUE("10", "宁波市税务局", ""),
    WEALTH_TAX("11", "市财税局", ""),
    EMERGENCY_MANAGEMENT("12", "市应急管理局", ""),
    FUEL_GAS("13", "市兴光燃气集团", ""),
    ABNORMAL_BANK_ACCOUNT("14", "银行账户异动信息", ""),
    BUREAU_OF_COMMERCE("15", "市商务局", ""),
    TAP_WATER_COMPANY("16", "市自来水公司", ""),
    BY_THE_LETTER("17", "市经信局", ""),
    ENFORCEMENT("18", "市综合执法局", ""),
    PETITION_LETTER("19", "市信访局", ""),
    MARKET_SUPERVISE("20", "市市场监管局", "/market_supervise/find_list"),
    BUREAU_OF_LAND_RESOURCES("21", "宁波市国土资源局", ""),
    HOUSING_CONSTRUCTION_BUREAU("22", "市住建局", ""),
    POWER_SUPPLY("23", "国网宁波供电公司", ""),
    SECURITIES_REGULATORY("24", "宁波证监局", ""),
    ;

    private String id;
    private String value;
    private String url;

    DepartEnum(String id, String value, String url) {
        this.id = id;
        this.value = value;
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public static DepartEnum getValue(String value) {
        for (DepartEnum departEnum : DepartEnum.values()) {
            if (StringUtils.equals(value, departEnum.getValue())) {
                return departEnum;
            }
        }
        return null;
    }

    public static String getUrl(String id) {
        for (DepartEnum departEnum : DepartEnum.values()) {
            if (StringUtils.equals(id, departEnum.getId())) {
                return departEnum.getUrl();
            }
        }
        return null;
    }
}
