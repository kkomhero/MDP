package com.skt.mdp.DemoEnginePostWorker.Tools;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class runconfig {

    @Value("${spring.task.fixedDelay}") private String fixedDelay;

    public String getFixedDelay() {
        return fixedDelay;
    }

    public void setFixedDelay(String fixedDelay) {
        this.fixedDelay = fixedDelay;
    }
}