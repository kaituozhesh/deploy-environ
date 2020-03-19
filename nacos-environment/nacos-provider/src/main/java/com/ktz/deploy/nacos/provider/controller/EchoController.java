package com.ktz.deploy.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName EchoController
 * @Description
 * @Author kaituozhesh
 * @Date 2020/3/19 14:53
 * @Version V1.0
 **/
@RestController
public class EchoController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Provider " + string;
    }

    @GetMapping(value = "/lb")
    public String lb() {
        return "Hello Naocs Provider i am from port:" + port;
    }
}
