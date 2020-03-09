package com.ktz.deploy.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName: User
 * Description:
 * date: 2020/3/9 9:06
 *
 * @author kaituozhe_sh
 */
@Data
@ApiModel(value = "用户模型")
public class User {
    @ApiModelProperty("用户ID")
    private Integer id;
}
