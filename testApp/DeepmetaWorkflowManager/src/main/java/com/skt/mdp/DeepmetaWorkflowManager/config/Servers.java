package com.skt.mdp.DeepmetaWorkflowManager.config;

public class Servers {

    private String ip;
    private String max;
    private Integer current=0;

    public Integer getCurrent() {
        return this.current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMax() {
        return this.max;
    }

    public void setMax(String max) {
        this.max = max;
    }

}