package com.springMySql.SpringMySql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMySqlApplication.class, args);
	}

}
