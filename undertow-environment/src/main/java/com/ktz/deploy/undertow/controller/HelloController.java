package com.ktz.deploy.undertow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: HelloController
 * Description:
 * date: 2020/3/8 10:18
 *
 * @author kaituozhe_sh
 */
@RestController
@RequestMapping("/index")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Undertow";
    }

}

