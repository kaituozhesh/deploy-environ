package com.ktz.deploy.elasticsearch.dto;

import lombok.Data;

/**
 * ClassName: SearchDto
 * Description:
 * date: 2020/3/8 21:15
 *
 * @author kaituozhe_sh
 */
@Data
public class SearchDto {
    private Long categoryId;
    private Long brandId;
    private Long seriesId;
    private String newStatus;
}
