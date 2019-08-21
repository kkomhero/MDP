package com.skt.mdp.DemoEngineController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoEngineControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEngineControllerApplication.class, args);
		// try (ConfigurableApplicationContext ctx = SpringApplication.run(DemoEngineControllerApplication.class, args)) {
        //     runconfig conf = ctx.getBean(runconfig.class);
        //     //System.out.println(conf.getFixedDelay());
        // }
	}

}

// http://websystique.com/spring-boot/spring-boot-rest-api-example/
// https://www.baeldung.com/spring-request-param
// https://spring.io/guides/tutorials/rest/