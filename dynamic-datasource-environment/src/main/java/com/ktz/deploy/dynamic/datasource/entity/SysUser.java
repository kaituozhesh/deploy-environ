/**
 * Copyright 2020 the original author or authors.
 */
package com.ktz.deploy.dynamic.datasource.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Zhao Wanzi
 */
@Data
public class SysUser {
    /**
     * id
     */
    private Long id;

    private String uid;

    private String loginUser;

    private String loginPassword;

    private int type;

    private String createBy;


    private Date createDate;


    private String updateBy;

    private Date updateDate;


    private String remarks;


    private String smsCode;


    private String pwd;


    private Integer frozen;

    private Integer loginStats;


    private String delFlag;


    private String userName;


    private String names;

    private String hangye;

    private String orgName;


}
