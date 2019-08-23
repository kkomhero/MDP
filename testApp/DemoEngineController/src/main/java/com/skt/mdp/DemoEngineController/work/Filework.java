package com.skt.mdp.DemoEngineController.work;

import com.skt.mdp.DemoEngineController.config.RunConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Filework implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(Filework.class);

    private RunConfig runcfg;
    private WorkManager workmanager = null;
    private String mdpjabid;

    @Override
    public void run() {
        String jobstatus;
        //System.out.println("Filework="+runcfg.getOrgdir()+"::"+runcfg.getOrgdir());
        //System.out.println("start Filework");
        try {
            String saveDirectory = runcfg.getSavedir() +"/face/raw/"+mdpjabid;
            Path path = Paths.get(saveDirectory);
            Files.createDirectories(path);

            Path sourcepath = Paths.get(runcfg.getOrgdir()+"/suicide_squad_raw_face.csv");
            Path destinationepath = Paths.get(saveDirectory+"/suicide_squad_raw_face.csv");
            Files.copy(sourcepath, destinationepath, StandardCopyOption.REPLACE_EXISTING);

            for(int i=0; i<10; i++) {
                //System.out.println("i="+i);
                Thread.sleep(2000);
            }

            jobstatus = "success";
        } 
        catch (InterruptedException e) {
            System.out.println("InterruptedException receive !!");
            jobstatus = "fail";
            e.printStackTrace();
        } 
        catch (Exception e) {
            jobstatus = "fail";
            e.printStackTrace();
        }

        if(workmanager != null) {
            workmanager.setJobStauts(mdpjabid, jobstatus);
        }
    }

    public WorkManager getWorkmanager() {
        return workmanager;
    }

    public void setWorkmanager(WorkManager workmanager) {
        this.workmanager = workmanager;
    }

    public String getMdpjabid() {
        return mdpjabid;
    }

    public void setMdpjabid(String mdpjabid) {
        this.mdpjabid = mdpjabid;
    }

    public RunConfig getRuncfg() {
        return runcfg;
    }

    public void setRuncfg(RunConfig runcfg) {
        this.runcfg = runcfg;
    }
}