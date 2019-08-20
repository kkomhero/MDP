package com.mbg.otdev.esDemo.controller;

import com.mbg.otdev.esDemo.config.config;
import com.mbg.otdev.esDemo.dao.GreetingRepository;
import com.mbg.otdev.esDemo.model.Greeting;
import com.mbg.otdev.esDemo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private config cfg;

    @Autowired
    GreetingRepository repository;
    @Autowired
    ElasticsearchTemplate template;



    @ResponseBody
    @RequestMapping(value = "/greetings", method = RequestMethod.GET)
    public ResponseEntity<List<Greeting>> getAll() {
        return new ResponseEntity<List<Greeting>>(greetingService.getAll(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/greetings", method = RequestMethod.POST)
    public ResponseEntity<Greeting> insertGreeting(@RequestBody Greeting greeting) {

        //template.createIndex("myindex3");
        //template.putMapping(Greeting.class);
        //template.refresh("myindex3");
        //template.refresh(Greeting.class);

        //cfg.setSaveIndexName("abindex1");
        //System.out.println(cfg.getSaveIndexName());

        return null;
        //return new ResponseEntity<Greeting>(greetingService.create(greeting), HttpStatus.CREATED);
    }
}
