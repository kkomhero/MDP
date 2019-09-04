package com.skt.mdp.DemoEngineController.work;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

import com.skt.mdp.DemoEngineController.config.RunConfig;
import com.skt.mdp.DemoEngineController.model.FacefileReq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MergeWork implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(Filework.class);

    private FacefileReq facefilereq;
    private RunConfig runcfg;
    private WorkManager workmanager = null;

    @Override
    public void run() {
        String jobstatus;

        String filefullpath = facefilereq.getReusltPath();
		int spos = filefullpath.lastIndexOf("/");
        String fileNameext = filefullpath.substring(spos+1, filefullpath.length());
        int pos = fileNameext.lastIndexOf(".");
        String fileName = fileNameext.substring(0, pos);
        log.info("faceRawWork start => "+filefullpath +"::"+fileName);


        HashMap<String,String> reulstMap = new HashMap<String,String>();
        String resultpath = "";

        try {
            String saveDirectory = runcfg.getSavedir() +"/face/merge/"+facefilereq.getMdpJobId();
            Path path = Paths.get(saveDirectory);
            Files.createDirectories(path);

            resultpath = saveDirectory+"/suicide_squad_raw_merge.csv";
            Path sourcepath = Paths.get(runcfg.getOrgdir()+"/suicide_squad_merge_face.csv");
            Path destinationepath = Paths.get(resultpath);
            Files.copy(sourcepath, destinationepath, StandardCopyOption.REPLACE_EXISTING);

        }catch(Exception e) {

        }

    }


    public FacefileReq getFacefilereq() {
        return this.facefilereq;
    }

    public void setFacefilereq(FacefileReq facefilereq) {
        this.facefilereq = facefilereq;
    }

    public RunConfig getRuncfg() {
        return this.runcfg;
    }

    public void setRuncfg(RunConfig runcfg) {
        this.runcfg = runcfg;
    }

    public WorkManager getWorkmanager() {
        return this.workmanager;
    }

    public void setWorkmanager(WorkManager workmanager) {
        this.workmanager = workmanager;
    }

}