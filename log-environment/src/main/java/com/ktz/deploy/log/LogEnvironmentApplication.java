package com.ktz.deploy.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class LogEnvironmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogEnvironmentApplication.class, args);
	}

}
