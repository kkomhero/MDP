package com.skt.mdp.DemoEngineController.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RunConfig {

    @Value("${runconfig.orgdir}")
    private String orgdir;

    @Value("${runconfig.savedir}")
    private String savedir;
    
    /**
     * @return String return the orgdir
     */
    public String getOrgdir() {
        return orgdir;
    }

    /**
     * @param orgdir the orgdir to set
     */
    public void setOrgdir(String orgdir) {
        this.orgdir = orgdir;
    }

    /**
     * @return String return the savedir
     */
    public String getSavedir() {
        return savedir;
    }

    /**
     * @param savedir the savedir to set
     */
    public void setSavedir(String savedir) {
        this.savedir = savedir;
    }

}