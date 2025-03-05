package com.fintech.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.fintech.api.repositories") // Añade esto
public class SvFintechApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvFintechApiApplication.class, args);
	}

}