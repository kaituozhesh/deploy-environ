package com.ktz.deploy.oauth2.resource.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "tb_content_category")
public class TbContentCategory implements Serializable {
    /**
     * 类目ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 父类目ID=0时，代表的是一级的类目
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 分类名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 状态。可选值:1(正常),2(删除)
     */
    @Column(name = "`status`")
    private Integer status;

    /**
     * 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
     */
    @Column(name = "sort_order")
    private Integer sortOrder;

    /**
     * 该类目是否为父类目，1为true，0为false
     */
    @Column(name = "is_parent")
    private Boolean isParent;

    /**
     * 创建时间
     */
    @Column(name = "created")
    private Date created;

    /**
     * 创建时间
     */
    @Column(name = "updated")
    private Date updated;

    private static final long serialVersionUID = 1L;
}