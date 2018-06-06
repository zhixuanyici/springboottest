package com.yaic.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//mybatis reload xml
@MapperScan(basePackages={"com.yaic.auth.thirdParty.dao","com.yaic.auth.interior.dao"})
public class Run{
	
	public static void main(String[] args) {
		SpringApplication.run(Run.class, args);
	}
}
