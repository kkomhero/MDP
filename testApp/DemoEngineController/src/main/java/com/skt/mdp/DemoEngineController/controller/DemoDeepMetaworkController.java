package com.skt.mdp.DemoEngineController.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skt.mdp.DemoEngineController.Tools.runconfig;
import com.skt.mdp.DemoEngineController.model.ApiResponseMessage;
import com.skt.mdp.DemoEngineController.model.JobInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deepwork")
public class DemoDeepMetaworkController {
    public static final Logger logger = LoggerFactory.getLogger(DemoDeepMetaworkController.class);
    public static int reqcount = 0;

    @Autowired
    private runconfig runcfg;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String isRunning() {
        System.out.println(runcfg.getFixedDelay());
        return "I'm Alive!";
    }


    //@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addJob(@RequestBody JobInfo jobinfo)
    {
        logger.info(jobinfo.getServiceId()+","+jobinfo.getEpsdId());

        try{
            Thread.sleep(2*1000);
        }catch(Exception e) {}

        //ApiResponseMessage message = new ApiResponseMessage("Success", "Job create", "", "");
    
        //return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.CREATED);
        String message = "Success";
        return new ResponseEntity<String>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<String> jogStatus(@RequestParam String service_id) {
        String message = "Processing";

        if (reqcount++ > 3) 
        {
            message =  "Complete";
            reqcount = 0;
        }

        ApiResponseMessage result = new ApiResponseMessage(service_id, message , "Job create", "", "");
        ObjectMapper mapper = new ObjectMapper();
        String resultJson = "";
        try {
            resultJson = mapper.writeValueAsString(result);
        }catch(Exception e) {
            e.printStackTrace();
        }

        logger.info("reqcount=" + reqcount);
        return new ResponseEntity<String>(resultJson, HttpStatus.OK);
    }


}