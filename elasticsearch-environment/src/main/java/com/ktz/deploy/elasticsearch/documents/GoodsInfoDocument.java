package com.ktz.deploy.elasticsearch.documents;

import com.frameworkset.orm.annotation.ESId;
import lombok.Data;
import org.frameworkset.elasticsearch.entity.ESBaseData;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ClassName: GoodsInfoDocument
 * Description:
 * date: 2020/3/8 19:40
 *
 * @author kaituozhe_sh
 */
@Data
public class GoodsInfoDocument extends ESBaseData implements Serializable {

    private static final long serialVersionUID = 1L;
    @ESId
    private String infoId;
    // 商品唯一号
    private String goodsSn;
    // 分类ID
    private Long categoryId;
    // 一级分类ID
    private Long cateParentId;
    // 分类名称
    private String categoryName;
    // 品牌ID
    private Long brandId;
    // 品牌名称
    private String brandName;
    // 系列ID
    private Long seriesId;
    // 系列名称
    private String seriesName;
    // 商品名称
    private String goodsName;
    // SPU编号
    private String goodsCode;
    // 所属国家
    private String areaCode;
    // 产品图片
    private String showPics;
    // 上架状态  0->下架；1->上架；2-预上架
    private Integer publishStatus;
    // 新品状态 1-精品，2-新品，3-热销，12，23，13，123
    private String newStatus;
    // 中文显示
    private String newStatusStr;
    // 推荐状态；0->不推荐；1->推荐
    private Integer recommandStatus;
    // 市场价
    private String price;
    // 最低价
    private BigDecimal minPrice;
    // 本店价
    private String localPrice;
    // 副标题
    private String subTitle;
    // 商品描述
    private String description;
    // 关键词
    private String keywords;
    // 供应商ID
    private Long supplyId;
    // 排序
    private Integer sortOrder;
    // 删除状态：0->未删除；1->已删除
    private Integer disabled;

    public void setPrice(String price) {
        if (price.indexOf("-") != -1) {
            this.setMinPrice(new BigDecimal(price.substring(0, price.indexOf("-"))));
        } else {
            this.setMinPrice(new BigDecimal(price));
        }
        this.price = price;
    }
}

