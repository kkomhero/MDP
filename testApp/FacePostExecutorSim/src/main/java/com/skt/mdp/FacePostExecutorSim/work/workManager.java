package com.skt.mdp.FacePostExecutorSim.work;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.skt.mdp.FacePostExecutorSim.config.runConfig;
import com.skt.mdp.FacePostExecutorSim.model.FacefileReq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class workManager {
    
    @Autowired
    private runConfig runcfg;
    
    public int executeFaceRaw(FacefileReq fileReq) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        faceRawWork fw = new faceRawWork();
        fw.setFacefilereq(fileReq);
        fw.setWorkmanager(this);
        fw.setRuncfg(runcfg);
        //Runnable worker = new faceRawWork();
        Future<?> future = executor.submit(fw);
        executor.shutdown();

        return 1;
    }
}