package com.mbg.otdev;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class microsvc3App {

    public static void main(String[] args) {
        SpringApplication.run(microsvc3App.class, args);

    }
}

@RestController
class ServiceController {

    @Autowired
    RestTemplate restTemplate;
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    private static final Logger LOG = Logger.getLogger(ServiceController.class.getName());

    @RequestMapping("/internal/coffees")
    public String coffeessList(@RequestHeader(value="X-B3-TraceId") String traceId) throws Exception {

        LOG.info("Inside MicroService 3..");
        LOG.info("Receive Trace Id = "+ traceId);
        LOG.info("Now let's create some intentional send...");

        if(true) {
            throw new Exception("MicroService 3 occur Exception");
        }
        return "Americano, Latte, Moca";
    }
}