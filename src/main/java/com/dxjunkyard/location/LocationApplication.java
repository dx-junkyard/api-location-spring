package com.dxjunkyard.location;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dxjunkyard.location.repository.dao.mapper")
public class LocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationApplication.class, args);
	}

}
