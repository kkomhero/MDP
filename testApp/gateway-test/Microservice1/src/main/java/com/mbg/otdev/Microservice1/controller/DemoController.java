package com.mbg.otdev.Microservice1.controller;

import java.util.stream.Collectors;

import com.netflix.appinfo.providers.EurekaConfigBasedInstanceInfoProvider;
import com.netflix.discovery.EurekaClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mdp")
public class DemoController {

    @Autowired
    EurekaClient eurekaClient;

    @GetMapping(value = "/get-data")
    //public ResponseEntity<String> microservicemsg (ServerHttpRequest request, ServerHttpResponse response) {
    public ResponseEntity<String> test(@RequestHeader MultiValueMap<String, String> headers){
        headers.forEach((key, value) -> {
            System.out.println(String.format("Header '%s' = %s", key, value.stream().collect(Collectors.joining("|"))));
        });

        return new ResponseEntity<String>(String.format("Listed %d headers", headers.size()), HttpStatus.OK);
    }

    @GetMapping(value = "/get-info")
    //public ResponseEntity<String> microservicemsg (ServerHttpRequest request, ServerHttpResponse response) {
    public void getInfo() {
        
        String eurkaId = eurekaClient.getApplicationInfoManager().getInfo().getInstanceId();

        System.out.println(eurkaId);
        
        return;
    }

}