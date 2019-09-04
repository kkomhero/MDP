package com.skt.mdp.FacePostExecutorSim.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skt.mdp.FacePostExecutorSim.config.runConfig;
import com.skt.mdp.FacePostExecutorSim.model.ApiResponseMessage;
import com.skt.mdp.FacePostExecutorSim.model.FacefileReq;
import com.skt.mdp.FacePostExecutorSim.model.JobStatus;
//import com.skt.mdp.FacePostExecutorSim.service.SaveService;
import com.skt.mdp.FacePostExecutorSim.work.workManager;

import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postface")
public class FaceController {
    public static final Logger logger = LoggerFactory.getLogger(FaceController.class);

    @Autowired
    runConfig runcfg;
    
	@Autowired
    workManager workmanager;

    @RequestMapping(value = "/face-raw", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> insertFacerawFromFile(@RequestBody FacefileReq facefilereq) {

        workmanager.executeFaceRaw(facefilereq);
        //saveService.addfaceraw(facefilereq);

        String message = "Success";
        return new ResponseEntity<String>(message, HttpStatus.CREATED);
    }

    //@GetMapping("/sample")
    @GetMapping
    public ResponseEntity<String> jobStatus(@RequestParam String mdpJobId) {
    
        //String message = faceEngine.getJobStatus(mdpJobId);
        JobStatus jobstatus = workmanager.getJobStatus(mdpJobId);

        logger.info("job stataus message =" + jobstatus.getCompleteMessage());

        ApiResponseMessage result = new ApiResponseMessage(mdpJobId, jobstatus.getCompleteMessage() , "Job create", "", "", jobstatus.getResultMap().get("resultpath"));
        ObjectMapper mapper = new ObjectMapper();
        String resultJson = "";
        try {
            resultJson = mapper.writeValueAsString(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<String>(resultJson, HttpStatus.OK);

    }
    
}