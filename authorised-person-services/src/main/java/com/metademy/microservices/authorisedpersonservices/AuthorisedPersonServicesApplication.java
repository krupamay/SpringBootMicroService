package com.metademy.microservices.authorisedpersonservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.metademy.microservices")
public class AuthorisedPersonServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorisedPersonServicesApplication.class, args);
	}
}
