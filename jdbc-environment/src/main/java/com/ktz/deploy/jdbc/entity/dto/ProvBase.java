package com.ktz.deploy.jdbc.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProvBase {

    private Integer id;

    private String tableName;

    private String tableChnname;

    private String fieldName;

    private String fieldChnname;

    private Integer type;

    private Date createTime;

    private Date modifyTime;


}