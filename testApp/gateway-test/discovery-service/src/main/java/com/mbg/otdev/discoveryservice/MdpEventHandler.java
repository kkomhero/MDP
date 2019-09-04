package com.mbg.otdev.discoveryservice;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MdpEventHandler {

    @EventListener
    public void handle(EurekaInstanceCanceledEvent cancleEvent) {
        System.out.println("*** MdpEventHandler=>"+cancleEvent.getAppName()+">>"+cancleEvent.getServerId());

        RestTemplate restTemplate = new RestTemplate();
 
        HttpEntity<Foo> request = new HttpEntity<>(new Foo("bar"));
        Foo foo = restTemplate.postForObject(fooResourceUrl, request, Foo.class);

/*
        RestTemplate restTemplate = new RestTemplate();

    String reqBody = "{"city": "Ranchi"}";
    String result = restTemplate.postForObject(uri, reqBody, String.class);

    // convert your result into json

    try {
                jsonResponse = new JSONObject(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
   //extract a value "name" from your json data:
   try{
    String value = jsonResponse.getString("name");  
    }catch(JSONException e) {
            e.printStackTrace();
        }

        */
    }
}