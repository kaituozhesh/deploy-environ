package com.ktz.deploy.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName: FeignApplication
 * Description:
 * date: 2020/3/8 21:55
 *
 * @author kaituozhe_sh
 */
@EnableFeignClients(basePackages = {"com.ktz.deploy.feign.service.feign"})
@SpringBootApplication
public class FeignCallerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignCallerApplication.class, args);
    }
}
