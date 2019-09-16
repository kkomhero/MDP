package com.skt.mdp.DeepmetaWorkflowManager.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import com.skt.mdp.DeepmetaWorkflowManager.config.EngineInfo;
import com.skt.mdp.DeepmetaWorkflowManager.config.Engines;
import com.skt.mdp.DeepmetaWorkflowManager.config.LoadConfig;
import com.skt.mdp.DeepmetaWorkflowManager.config.Servers;
import com.skt.mdp.DeepmetaWorkflowManager.config.TestConfig;
import com.skt.mdp.DeepmetaWorkflowManager.config.TestConfigController;
import com.skt.mdp.DeepmetaWorkflowManager.work.WorkerManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    // @Autowired
    // private EngineInfo engineinfo;

    @Autowired
    TestConfig testConfig;

    // @Autowired
    // LoadConfig LoadConfig;

    // @Autowired
    // WorkerManager workermanager;

    // @Autowired
    // TestConfigController testconfigcontoller;

    @GetMapping
    public ResponseEntity<String> testconfig() {
        List<Engines> engines = testConfig.getEngines();
        ConcurrentHashMap <String,Servers> serverMap = testConfig.getServerMap();

        for (String key : serverMap.keySet()) {

            Servers server = serverMap.get(key);
            System.out.println(key+"=>" + server.getIp());
            System.out.println(key+"=>"+ server.getCurrent()  );

            Integer cur = server.getCurrent();
            server.setCurrent(cur+1);
        }

        // ConcurrentHashMap <String,Servers> serverMap = testconfigcontoller.getServerMap();
        // System.out.println(serverMap.size());

        // ConcurrentHashMap <String,Server> serverMap = testConfig.getServerMap();
        // for (String key : serverMap.keySet()) {
        //     Server server = serverMap.get(key);
        //     System.out.println(key+"=>"  );
        //     // System.out.println(key+"=>"+ server.getCurrent()  );

        //     // Integer cur = server.getCurrent();
        //     // server.setCurrent(cur+1);
        // }


        //workermanager.setConfig();
        // List<Map<String, String>> servers = engineinfo.getServers();
        // System.out.println(servers);

        //System.out.println(testConfig.getServers());

        // List<Engines> engines = testConfig.getEngines();
        // System.out.println(engines.size());
        // for (Engines engine : engines) {
        //     System.out.println(engine.getType());
        //     List<Servers> servers = engine.getServers();
        //     for (Servers server : servers) {
        //         System.out.println(server.getIp()+":"+server.getMax());
        //     }

        // }
        
        //System.out.println(testConfig.getEngines());

        // try {
        //     LoadConfig.getYml();
        // }catch (Exception e) {
        //     e.printStackTrace();
        // }
       

        return null;
    }

}