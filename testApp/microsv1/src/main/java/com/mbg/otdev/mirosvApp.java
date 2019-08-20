package com.mbg.otdev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class mirosvApp {
    public static void main(String[] args) {
        SpringApplication.run(mirosvApp.class, args);

    }
}

@RestController
class HomeController {
    //HomeService homeService;

    @Autowired
    RestTemplate restTemplate;
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private Tracer tracer;

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/")
    public String home() {

        LOG.info("Inside MicroService 1..");
        LOG.info("Start traceId=" + tracer.getCurrentSpan().traceIdString());
        return restTemplate.getForObject("http://localhost:8082/external/coffees", String.class);

    }

}

/*
@Service
class HomeService {

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    private static final Logger LOG = Logger.getLogger(HomeService.class.getName());

    public String coffeeList() {
        LOG.info("Inside MicroService 1..");
        return restTemplate.getForObject("http://localhost:8082/external/coffees", String.class);
    }

}
*/
