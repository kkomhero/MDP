package com.skt.mdp.DeepmetaWorkflowManager.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.skt.mdp.DeepmetaWorkflowManager.YamlPropertySourceFactory;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:deepmetaengine.yml")
@ConfigurationProperties(prefix="deepmeta")
public class TestConfig {

    private String savepath;
    private String filename;
    private List<Engines> engines = new ArrayList<Engines>();
    private ConcurrentHashMap <String,Servers> serverMap = new ConcurrentHashMap <> ();
    
    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSavepath() {
        return this.savepath;
    }

    public void setSavepath(String savepath) {
        this.savepath = savepath;
    }


    public List<Engines> getEngines() {
        return this.engines;
    }

    public void setEngines(List<Engines> engines) {
        this.engines = engines;

        System.out.println("22222222222222222222");
        setServerInfo();
    }


    public ConcurrentHashMap<String,Servers> getServerMap() {
        return this.serverMap;
    }

    public void setServerMap(ConcurrentHashMap<String,Servers> serverMap) {
        this.serverMap = serverMap;
    }


    public void setServerInfo() {
        for (Engines engine : this.engines) {
            List<Servers> servers = engine.getServers();
            for (Servers server : servers) {
                System.out.println(server.getIp()+":"+server.getMax()   );
                serverMap.put(server.getIp(), server);
            }
 
        }

        String finename = getSavepath() +"/"+getFilename();
        System.out.println("filename="+finename);
        try{
            //파일 객체 생성
            File file = new File(finename);
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null){
                System.out.println(line);
            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.            
            bufReader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }



}