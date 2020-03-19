package com.ktz.deploy.nacos.consumer.controller;

import com.ktz.deploy.nacos.consumer.service.EchoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName FeignController
 * @Description
 * @Author kaituozhesh
 * @Date 2020/3/19 15:15
 * @Version V1.0
 **/
@RefreshScope
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Resource
    private EchoService echoService;

    @Value("${user.name}")
    private String username;

    @GetMapping("/echo/{str}")
    public String feignEcho(@PathVariable String str) {
        return echoService.echo(str);
    }

    @GetMapping("/lb")
    public String feignlb() {
        return echoService.lb();
    }

    @GetMapping("/echo_name")
    public String feignEchoName() {
        return echoService.echoName(username);
    }
}
