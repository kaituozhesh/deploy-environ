package com.ktz.deploy.jdbc.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName DepartDataDto
 * @Description 部门首页数据统计DTO
 * @Author kaituozhesh
 * @Date 2020/3/26 13:05
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartDataDto implements Serializable {

    /**
     * 首页块对应ID
     */
    private String id;

    /**
     * 块列表对应ID 的对应请求列表url
     */
    private String url;

    /**
     * 首页块对应的名称
     */
    private String name;

    /**
     * 首页块对应的数据总量
     */
    private Long totalCount;


}
