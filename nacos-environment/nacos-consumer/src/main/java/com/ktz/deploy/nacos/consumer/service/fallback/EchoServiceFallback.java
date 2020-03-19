package com.ktz.deploy.nacos.consumer.service.fallback;

import com.ktz.deploy.nacos.consumer.service.EchoService;
import org.springframework.stereotype.Component;

/**
 * @ClassName EchoServiceImpl
 * @Description
 * @Author kaituozhesh
 * @Date 2020/3/19 15:13
 * @Version V1.0
 **/
@Component
public class EchoServiceFallback implements EchoService {
    @Override
    public String echo(String string) {
        return "echo fail";
    }

    @Override
    public String lb() {
        return "lb fail";
    }
}
