package com.skt.mdp.DemoEngineController.service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skt.mdp.DemoEngineController.model.FacefileReq;
import com.skt.mdp.DemoEngineController.model.JobInfo;
import com.skt.mdp.DemoEngineController.model.JobStatus;
import com.skt.mdp.DemoEngineController.work.WorkManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class FaceEngine {
    public static final Logger log = LoggerFactory.getLogger(FaceEngine.class);

    private ObjectMapper objectMapper;

    @Autowired
    private WorkManager workManager;

    @Autowired
    public FaceEngine(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.objectMapper.setSerializationInclusion(Include.NON_NULL);
        this.objectMapper.setSerializationInclusion(Include.NON_EMPTY);
    }

//    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
//    @Async
    public int addJob(JobInfo jobinfo) {
        log.info("[FaceEngine] add job start");
        int rtn = workManager.execute(jobinfo);

        return rtn;
    }

    public int addMergeJob(FacefileReq facefilereq) {
        log.info("[FaceEngine] add job start");
        int rtn = workManager.executeMergeJob(facefilereq);

        return rtn;
    }

    public JobStatus getJobStatus(String mdpjobid) {

        return workManager.getJobStatus(mdpjobid);
    }
}