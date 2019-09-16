package com.skt.mdp.DeepmetaWorkflowManager.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@PropertySource("classpath:deepmetaengine.yml")
@ConfigurationProperties(prefix = "servers")
//@ConfigurationProperties
public class EngineInfo {

    public List<Map<String, String>> servers = new ArrayList<Map<String, String>>(); 
    
    public List<Map<String, String>> getServers() { return servers; }
    
	public void setServers(List<Map<String,String>> servers) {
        this.servers = servers;
    }

    // private List<Servers> servers = new ArrayList<>();

    // public List<Servers> getServers() {
    //     return this.servers;
    // }

    // public void setServers(List<Servers> servers) {
    //     this.servers = servers;
    // }




}