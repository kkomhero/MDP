package com.skt.mdp.DeepmetaWorkflowManager.work;

import java.util.List;

import com.skt.mdp.DeepmetaWorkflowManager.config.Engines;
import com.skt.mdp.DeepmetaWorkflowManager.config.Servers;
import com.skt.mdp.DeepmetaWorkflowManager.config.TestConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerManager {

    @Autowired
    TestConfig testConfig;


    public void setConfig () {

        // List<Engines> engines = testConfig.getEngines();
        // System.out.println(engines.size());
        // for (Engines engine : engines) {
        //     System.out.println(engine.getType());
        //     List<Server> servers = engine.getServer();
        //     for (Server server : servers) {
        //         System.out.println(server.getIp()+":"+server.getMax()   );

        //     }
 
        // }
    }
}