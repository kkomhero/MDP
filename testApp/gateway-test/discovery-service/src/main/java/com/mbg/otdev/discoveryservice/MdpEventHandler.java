package com.mbg.otdev.discoveryservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MdpEventHandler {
    private static final Logger log = LoggerFactory.getLogger(MdpEventHandler.class);

    @Value("${uris.baseUrl}")
    private String base_url;

    @Value("${uris.jobcontrollerUrl.baseUrl}")
    private String jobcontroller_url;

    @Value("${uris.jobcontrollerUrl.serviceStatus}")
    private String jobcontroller_starus_url;

    @EventListener
    public void handle(EurekaInstanceCanceledEvent cancleEvent) {
        
        log.info("*** MdpEventHandler=>"+cancleEvent.getAppName()+">>"+cancleEvent.getServerId());

        //String request_url = base_url+"/"+jobcontroller_url+"/"+jobcontroller_starus_url+"/"+cancleEvent.getAppName()+"/"+cancleEvent.getServerId();
        String request_url = jobcontroller_starus_url+"/"+cancleEvent.getAppName()+"/"+cancleEvent.getServerId();
        log.info("request url = "+request_url);

        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Void> responseEntity=restTemplate.exchange(request_url, HttpMethod.PUT,null,Void.class);
            log.info("status code="+responseEntity.getStatusCode());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}