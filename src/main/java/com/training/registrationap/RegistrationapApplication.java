package com.training.registrationap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RegistrationapApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationapApplication.class, args);
	}

}
