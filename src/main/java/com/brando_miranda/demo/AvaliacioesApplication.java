package com.brando_miranda.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
public class AvaliacioesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvaliacioesApplication.class, args);
	}

}
