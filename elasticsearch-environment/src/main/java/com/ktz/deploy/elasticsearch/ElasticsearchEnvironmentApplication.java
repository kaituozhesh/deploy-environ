package com.ktz.deploy.elasticsearch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ktz.deploy.elasticsearch.mapper*")
@SpringBootApplication
public class ElasticsearchEnvironmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchEnvironmentApplication.class, args);
    }

}
