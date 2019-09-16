package com.skt.mdp.DeepmetaWorkflowManager.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

@Component
public class LoadConfig {

    @Autowired 
    private ResourceLoader resourceLoader; 

    public void getYml() throws IOException {
        
        String path = "resources/test.yml";
                
        Yaml yaml = new Yaml();  
        
        HashMap<String, Object> hm = new HashMap<String, Object>();
        HashMap<String, String> sm = new HashMap<String, String>();
        
        hm = yaml.load(new FileInputStream(new File(resourceLoader.getResource(path).getURI().getPath())));
        sm = (HashMap<String, String>) hm.get("datasource1");
        System.out.println(sm.get("name") + " | " + sm.get("pass") + " | " + sm.get("url"));
        System.out.println("=======================================================================================");
        System.out.println(yaml.dump(hm));  
    }
}