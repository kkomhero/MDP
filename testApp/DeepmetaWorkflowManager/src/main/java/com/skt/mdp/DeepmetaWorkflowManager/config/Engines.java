package com.skt.mdp.DeepmetaWorkflowManager.config;

import java.util.List;

public class Engines {
    private String type;
    private List<Servers> servers;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Servers> getServers() {
        return this.servers;
    }

    public void setServers(List<Servers> servers) {
        this.servers = servers;
        System.out.println("000-11111111111111");
    }


}