package com.cjc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EntityScan("com.cjc.main.model")
@EnableJpaRepositories
@SpringBootApplication
public class SpringbootdatajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdatajpaApplication.class, args);
	}

}
