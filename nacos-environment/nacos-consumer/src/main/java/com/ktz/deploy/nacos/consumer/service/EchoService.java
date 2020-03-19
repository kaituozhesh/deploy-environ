package com.ktz.deploy.nacos.consumer.service;

import com.ktz.deploy.nacos.consumer.service.fallback.EchoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-provider", fallback = EchoServiceFallback.class)
public interface EchoService {

    @GetMapping("/echo/{string}")
    String echo(@PathVariable String string);

    @GetMapping(value = "/lb")
    String lb();

    @GetMapping("/show/{name}")
    String echoName(@PathVariable String name);
}
