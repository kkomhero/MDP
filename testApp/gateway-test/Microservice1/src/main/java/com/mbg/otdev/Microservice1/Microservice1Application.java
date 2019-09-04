package com.mbg.otdev.Microservice1;

import com.mbg.otdev.Microservice1.controller.DemoController;
import com.netflix.discovery.EurekaClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Microservice1Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Microservice1Application.class, args);

		// Microservice1Application ma = new Microservice1Application();
		// ma.getEurekaInstansId();
	}

}
