package com.mbg.otdev;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class microsvc2App {
    public static void main(String[] args) {
        SpringApplication.run(microsvc2App.class, args);

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

    @RequestMapping("/external/coffees")
    public String delay(@RequestHeader(value="X-B3-TraceId") String traceId) {

        LOG.info("Inside MicroService 2..");
        LOG.info("Receive Trace Id = "+ traceId);
        LOG.info("Now let's create some intentional delay...");
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            return "Exception Occur!!";
        }

        LOG.info("returning afte delay..");
        String response = (String) restTemplate.getForObject("http://localhost:8083/internal/coffees", String.class);

        LOG.info("receive ="+response);
        return response;

    }

}