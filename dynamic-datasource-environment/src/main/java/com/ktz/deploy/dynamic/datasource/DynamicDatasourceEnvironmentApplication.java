package com.ktz.deploy.dynamic.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.ktz.deploy.dynamic.datasource.mapper*")
@SpringBootApplication
public class DynamicDatasourceEnvironmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicDatasourceEnvironmentApplication.class, args);
	}

}
