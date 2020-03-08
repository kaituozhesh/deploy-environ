package com.ktz.deploy.elasticsearch.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("goods_info")
public class GoodsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("goods_sn")
    private String goodsSn;

    @TableField("category_id")
    private Long categoryId;

    @TableField("category_name")
    private String categoryName;

    @TableField("brand_id")
    private Long brandId;

    @TableField("brand_name")
    private String brandName;

    @TableField("series_id")
    private Long seriesId;

    @TableField("series_name")
    private String seriesName;

    @TableField("goods_name")
    private String goodsName;


    @TableField("new_status")
    private String newStatus;

    @TableField("price")
    private String price;

    @TableField("sort_order")
    private Integer sortOrder;



}