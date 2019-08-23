package com.skt.mdp.DemoEngineController.work;

import com.skt.mdp.DemoEngineController.config.RunConfig;
import com.skt.mdp.DemoEngineController.model.JobInfo;

import com.skt.mdp.DemoEngineController.model.JobStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class WorkManager {
    public static final Logger log = LoggerFactory.getLogger(WorkManager.class);
    
    @Autowired
    private RunConfig runcfg;

    private CheckThreadstatus checkThread = null;
    
    public int execute(JobInfo jobinfo) {
        log.info("[WorkManager] service: Deepmeta service start");
        log.info("[WorkManager]"+runcfg.getOrgdir()+"::"+runcfg.getSavedir());

        if (checkThread == null ) {
            checkThread = new CheckThreadstatus();
            Thread ckt = new Thread(checkThread);
            ckt.start();
        }

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Filework fw = new Filework();
        fw.setMdpjabid(jobinfo.getMdpJobId());
        fw.setRuncfg(runcfg);
        fw.setWorkmanager(this);
        //Runnable worker = new Filework();
        Future<?> future = executor.submit(fw);
        executor.shutdown();

        checkThread.addJob(jobinfo.getMdpJobId(), future);

        return 1;
    }

    public void setJobStauts (String mdpjobid, HashMap<String,String> resultMap) {
        log.debug("job status="+ mdpjobid +":"+ resultMap.get("jobstatus"));

        checkThread.setJobStatus(mdpjobid,resultMap);
    }

    public JobStatus getJobStatus(String mdpjobid) {

        return checkThread.getJobStatus(mdpjobid);
    }
}
