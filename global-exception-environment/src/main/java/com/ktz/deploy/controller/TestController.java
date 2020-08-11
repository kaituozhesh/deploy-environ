package com.ktz.deploy.controller;

import com.ktz.deploy.exception.GlobalException;
import com.ktz.deploy.response.ResponseData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description
 * @Author 开拓者-骚豪
 * @Date 2020/8/11 10:00
 * @Version V1.0.0
 **/
@RestController
public class TestController {

    @RequestMapping("/test1/{id}")
    public ResponseData test1(@PathVariable Integer id) {
        if (id == 1) {
            throw new GlobalException("test1");
        }
        return ResponseData.ok();
    }

    @RequestMapping("/test2")
    public ResponseData test2() {

        Integer.parseInt("abc123");

        return ResponseData.ok();
    }


}
