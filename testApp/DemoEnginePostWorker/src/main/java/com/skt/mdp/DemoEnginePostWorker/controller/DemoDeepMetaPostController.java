package com.skt.mdp.DemoEnginePostWorker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deepworkpost")
public class DemoDeepMetaPostController {
    public static final Logger logger = LoggerFactory.getLogger(DemoDeepMetaPostController.class);
    public static int reqcount = 0;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String isRunning() {
        //System.out.println(runcfg.getFixedDelay());
        return "I'm Alive!";
    }

}