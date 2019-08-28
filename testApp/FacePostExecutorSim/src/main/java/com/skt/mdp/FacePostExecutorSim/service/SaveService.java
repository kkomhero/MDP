package com.skt.mdp.FacePostExecutorSim.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.skt.mdp.FacePostExecutorSim.model.FacefileReq;
import com.skt.mdp.FacePostExecutorSim.work.workManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveService {
    public static final Logger log = LoggerFactory.getLogger(SaveService.class);

    private ObjectMapper objectMapper;

    @Autowired
    private workManager workmanager;

    @Autowired
    public SaveService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.objectMapper.setSerializationInclusion(Include.NON_NULL);
        this.objectMapper.setSerializationInclusion(Include.NON_EMPTY);
    }

    public int addfaceraw(FacefileReq facefilereq) {
        log.info("[SaveService] add job start");
        int rtn = workmanager.executeFaceRaw(facefilereq);

        return rtn;
    }
}