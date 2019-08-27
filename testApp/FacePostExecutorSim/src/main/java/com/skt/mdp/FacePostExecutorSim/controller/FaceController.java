package com.skt.mdp.FacePostExecutorSim.controller;

import com.skt.mdp.FacePostExecutorSim.config.runConfig;
import com.skt.mdp.FacePostExecutorSim.model.FacefileReq;
import com.skt.mdp.FacePostExecutorSim.work.workManager;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postface")
public class FaceController {

    @Autowired
    runConfig runcfg;
    
	@Autowired
    private workManager workmanager;

    @RequestMapping(value = "/face-raw", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> insertFacerawFromFile(@RequestBody FacefileReq facefilereq) {

        workmanager.executeFaceRaw(facefilereq);

        String message = "Success";
        return new ResponseEntity<String>(message, HttpStatus.CREATED);
    }
    
}