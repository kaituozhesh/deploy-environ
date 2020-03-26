package com.ktz.deploy.jdbc.entity.dto;

import lombok.Data;

/**
 * @ClassName AbsDepartmetData
 * @Description
 * @Author kaituozhesh
 * @Date 2020/3/26 14:22
 * @Version V1.0
 **/
@Data
public abstract class AbsDepartmetData {
    /**
     * 分页的起始位置
     */
    private int startRow = 0;
    /**
     * 起始页 默认配置是合理化的。pageNum -1，0，1其实都指向第一页。从2开始指向对应页
     */
    private int pageNum = 0;
    /**
     * 单页上限,如果为0，则查询全部
     */
    private int pageSize = 0;
    /**
     * 列对应ID
     */
    private String marketId;

}
