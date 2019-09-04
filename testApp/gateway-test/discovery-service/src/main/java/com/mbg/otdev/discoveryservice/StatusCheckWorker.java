package com.mbg.otdev.discoveryservice;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.AbstractInstanceRegistry;
import com.netflix.eureka.registry.PeerAwareInstanceRegistryImpl;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import com.netflix.discovery.shared.Application;

import org.springframework.beans.factory.annotation.Autowired;

public class StatusCheckWorker extends Thread {

    public void run() {
        
        while (true) {
            PeerAwareInstanceRegistryImpl registry = (PeerAwareInstanceRegistryImpl) EurekaServerContextHolder.getInstance().getServerContext().getRegistry();

            List<Application> list = registry.getSortedApplications();
            System.out.println("list size = "+list.size());
            
            for (Application app : list) {
                for (InstanceInfo instance : app.getInstances()) {

                    System.out.println("Registered instance" +instance.getAppName() +"/"+instance.getId() +" with status="+instance.getStatus());

                    
                }
            }

            try {
                Thread.sleep(1000*30);
            }catch (Exception e) {

            }
        }
        
    }

}