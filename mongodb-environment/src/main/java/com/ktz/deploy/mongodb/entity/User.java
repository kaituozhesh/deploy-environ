package com.ktz.deploy.mongodb.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName: User
 * Description:
 * date: 2020/3/15 19:52
 *
 * @author kaituozhe_sh
 */
@ToString
@Data
public class User implements Serializable {

    private String id;
    private String name;
    private Integer age;

}
