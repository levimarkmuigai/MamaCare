package com.example.MamaCare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MamaCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(MamaCareApplication.class, args);
	}

}
