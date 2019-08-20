package com.mbg.otdev.esDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class EsDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(EsDemoApplication.class, args);

//		UUID one = UUID.randomUUID();
//		System.out.println("UUID One: " + one.toString());
	}

}
