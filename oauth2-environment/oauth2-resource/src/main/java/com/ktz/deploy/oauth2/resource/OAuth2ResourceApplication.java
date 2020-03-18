package com.ktz.deploy.oauth2.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName OAuth2ResourceApplication
 * @Description
 * @Author kaituozhesh
 * @Date 2020/3/18 10:43
 * @Version V1.0
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.ktz.deploy.oauth2.resource.mapper")
public class OAuth2ResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2ResourceApplication.class, args);
    }
}
