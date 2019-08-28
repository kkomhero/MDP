package com.skt.mdp.FacePostExecutorSim.work;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

import com.skt.mdp.FacePostExecutorSim.model.JobStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class workStatusChecker implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(workStatusChecker.class);
    ConcurrentHashMap<String, JobStatus> threaMap = new ConcurrentHashMap<>();

    @Override
    public void run() {
        //Thread t = Thread.currentThread();
        try {

            while (!Thread.currentThread().isInterrupted()) {
                for (String key : threaMap.keySet()) {
                    JobStatus status = threaMap.get(key);
                    log.info(key + "=" + status.getCompleteMessage());
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
        log.info("add job mdpjobid="+mdpjobid);
        JobStatus js = new JobStatus();
        js.setMdpJobId(mdpjobid);
        js.setFuture(future);
        js.setCompleteMessage("Process");
        threaMap.put(mdpjobid, js);
    }

    public JobStatus getJobStatus(String mdpjobid) {
        //String rtn = "";
        log.info("get job mdpjobid="+mdpjobid);
        JobStatus js = threaMap.get(mdpjobid);

        if(js == null) {
            js = new JobStatus();
            js.setMdpJobId(mdpjobid);
            js.setCompleteMessage("Not found MDP Job");
        }else {
            js.getCompleteMessage();
        }

        log.info(mdpjobid+"="+js.getCompleteMessage());

        if(!js.getCompleteMessage().equalsIgnoreCase("Process")) {
            threaMap.remove(mdpjobid);
        }

        return js;
    }

    public void setJobStatus(String mdpjobid, HashMap<String,String> resultMap) {
        JobStatus js = threaMap.get(mdpjobid);
        js.setCompleteMessage(resultMap.get("jobstatus"));
        js.setResultMap(resultMap);
    }
    
}