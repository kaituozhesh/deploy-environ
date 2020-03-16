package com.ktz.deploy.dynamic.datasource.controller;

import com.ktz.deploy.dynamic.datasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description
 * @Author kaituozhesh
 * @Date 2020/3/16 11:28
 * @Version V1.0
 **/
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public Object get(Integer id) {
        return userService.selectByPrimaryKey(id);
    }

}
