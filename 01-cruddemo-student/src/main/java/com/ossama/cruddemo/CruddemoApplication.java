package com.ossama.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// CommanLineRunner is from Spring boot
	@Bean
	public CommandLineRunner commandLineRunner() {
		return runner -> {
			// Executed after the Spring Beans have been loaded
			System.out.println("Hello from runner");
		};
	}

}
