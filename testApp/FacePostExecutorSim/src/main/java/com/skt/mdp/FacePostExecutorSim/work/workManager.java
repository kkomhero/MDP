package com.skt.mdp.FacePostExecutorSim.work;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.skt.mdp.FacePostExecutorSim.config.runConfig;
import com.skt.mdp.FacePostExecutorSim.model.FacefileReq;
import com.skt.mdp.FacePostExecutorSim.model.JobStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class workManager {
    public static final Logger log = LoggerFactory.getLogger(workManager.class);
    
    @Autowired
    private runConfig runcfg;

    private workStatusChecker checkThread = null;
    
    public int executeFaceRaw(FacefileReq fileReq) {
        log.info("[WorkManager] service: execute FaceRaw Save start");

        checkerThread();
        
        ExecutorService executor = Executors.newSingleThreadExecutor();
        faceRawWork fw = new faceRawWork();
        fw.setFacefilereq(fileReq);
        fw.setWorkmanager(this);
        fw.setRuncfg(runcfg);
        //Runnable worker = new faceRawWork();
        Future<?> future = executor.submit(fw);
        executor.shutdown();
        // boolean canceled = future.cancel(true);

        checkThread.addJob(fileReq.getMdpJobId(), future);

        return 1;
    }

    public void setJobStauts (String mdpjobid, HashMap<String,String> resultMap) {
        log.debug("job status="+ mdpjobid +":"+ resultMap.get("jobstatus"));

        checkThread.setJobStatus(mdpjobid,resultMap);
    }

    public JobStatus getJobStatus(String mdpjobid) {

        return checkThread.getJobStatus(mdpjobid);
    }
    
    public void checkerThread () {

        if (checkThread == null ) {
            checkThread = new workStatusChecker();
            Thread ckt = new Thread(checkThread);
            ckt.start();
        }
    }
}