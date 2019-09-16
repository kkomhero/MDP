package com.skt.mdp.DeepmetaWorkflowManager.config;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestConfigController implements ApplicationRunner {


    @Autowired
    private TestConfig testProperties;

    private ConcurrentHashMap <String,Servers> serverMap = new ConcurrentHashMap <> ();

    public ConcurrentHashMap<String,Servers> getServerMap() {
        return this.serverMap;
    }

    public void setServerMap(ConcurrentHashMap<String,Servers> serverMap) {
        this.serverMap = serverMap;
    }

    
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// System.out.println("username:"+userProperties.getName());
		// System.out.println("userId:"+userProperties.getId());
		// System.out.println("userPassword:"+userProperties.getPassword());
		// System.out.println("userCode:"+userProperties.getCode());
		// System.out.println("userComment:"+userProperties.getComment());
        
        List<Engines> engines = testProperties.getEngines();
        
        System.out.println("444444444444444444="+engines.size());
        System.out.println(engines);

        // for (Engines engine : engines) {
        //     System.out.println("66666666666666666");
        //     List<Server> servers = engine.getServer();
        //     System.out.println("5555555555="+servers.size());
        //     for (Server server : servers) {
        //         System.out.println(server.getIp()+":"+server.getMax()   );
        //         //serverMap.put(server.getIp(), server);
        //     }
 
        // }

		
	}

}