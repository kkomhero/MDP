package com.skt.mdp.DemoEngineController.work;

import com.skt.mdp.DemoEngineController.model.JobStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

public class CheckThreadstatus implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(CheckThreadstatus.class);

    ConcurrentHashMap<String, JobStatus> threaMap = new ConcurrentHashMap<>();

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        try {

            while (!Thread.currentThread().isInterrupted()) {
                for (String key : threaMap.keySet()) {
                    JobStatus status = threaMap.get(key);
                    log.debug(key + "=" + status.getCompleteMessage());
                }

                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println("InterruptedException receive !!");
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addJob(String mdpjobid, Future<?> future) {
        JobStatus js = new JobStatus();
        js.setMdpJobId(mdpjobid);
        js.setFuture(future);
        js.setCompleteMessage("Process");
        threaMap.put(mdpjobid, js);
    }

    public String getJobStatus(String mdpjobid) {
        String rtn = "";
        JobStatus js = threaMap.get(mdpjobid);

        if(js == null) {
            rtn = "Not found MDP Job";
        }else {
            rtn = js.getCompleteMessage();
        }

        log.debug(mdpjobid+"="+rtn);

        if(!js.getCompleteMessage().equalsIgnoreCase("Process")) {
            threaMap.remove(mdpjobid);
        }

        return rtn;
    }

    public void setJobStatus(String mdpjobid, String status) {
        JobStatus js = threaMap.get(mdpjobid);
        js.setCompleteMessage(status);
    }

}
