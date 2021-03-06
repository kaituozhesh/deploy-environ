package com.ktz.deploy.oauth2.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName OAuth2ServerApplication
 * @Description
 * @Author kaituozhesh
 * @Date 2020/3/16 14:15
 * @Version V1.0
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.ktz.deploy.oauth2.server.mapper")
public class OAuth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2ServerApplication.class, args);
    }
}
