package com.ktz.deploy.nacos.consumer.controller;

import com.ktz.deploy.nacos.consumer.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName FeignController
 * @Description
 * @Author kaituozhesh
 * @Date 2020/3/19 15:15
 * @Version V1.0
 **/
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private EchoService echoService;

    @GetMapping("/echo/{str}")
    public String feignEcho(@PathVariable String str) {
        return echoService.echo(str);
    }

}
