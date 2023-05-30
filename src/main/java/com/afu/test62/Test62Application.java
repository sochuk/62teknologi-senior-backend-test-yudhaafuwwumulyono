package com.afu.test62;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Test62Application {

	public static void main(String[] args) {
		SpringApplication.run(Test62Application.class, args);
	}

}
