package com.skt.mdp.DemoEngineController.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skt.mdp.DemoEngineController.config.RunConfig;
import com.skt.mdp.DemoEngineController.model.ApiResponseMessage;
import com.skt.mdp.DemoEngineController.model.JobInfo;
import com.skt.mdp.DemoEngineController.model.JobStatus;
import com.skt.mdp.DemoEngineController.service.FaceEngine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    private RunConfig runcfg;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String isRunning() {

        String message = runcfg.getOrgdir() + "::" + runcfg.getSavedir();
        System.out.println(message);
    
        return "I'm Alive => " + message;
    }

    @Autowired
    FaceEngine faceEngine;

    // @PostMapping(path= "/", consumes = "application/json", produces =
    // "application/json")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addJob(@RequestBody JobInfo jobinfo) {
        logger.info(jobinfo.getMdpJobId() +":"+ jobinfo.getEpisodeInfo().getEpisodeId());

        int rtn = faceEngine.addJob(jobinfo);
        System.out.println(rtn);
        // try {
        //     Thread.sleep(2 * 1000);
        // } catch (Exception e) {
        // }

        // // ApiResponseMessage message = new ApiResponseMessage("Success", "Job create",
        // // "", "");

        // // return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.CREATED);
        String message = "Success";
        return new ResponseEntity<String>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<String> jobStatus(@RequestParam String mdpJobId) {

        //String message = faceEngine.getJobStatus(mdpJobId);
        JobStatus jobstatus = faceEngine.getJobStatus(mdpJobId);

        logger.info("job stataus message =" + jobstatus.getCompleteMessage());

        ApiResponseMessage result = new ApiResponseMessage(mdpJobId, jobstatus.getCompleteMessage() , "Job create", "", "", jobstatus.getResultMap().get("resultpath"));
        ObjectMapper mapper = new ObjectMapper();
        String resultJson = "";
        try {
            resultJson = mapper.writeValueAsString(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info("reqcount=" + reqcount);
        return new ResponseEntity<String>(resultJson, HttpStatus.OK);
    }

}