package com.skt.mdp.DeepmetaWorkflowManager;

import com.skt.mdp.DeepmetaWorkflowManager.config.EngineInfo;
import com.skt.mdp.DeepmetaWorkflowManager.config.TestConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeepmetaWorkflowManagerApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(DeepmetaWorkflowManagerApplication.class, args);

		// etcTest et = new etcTest();
		// et.configtest();

		// TestConfig testConfig;
		// testConfig.setServerInfo();

	}

}



// http://sblog.netraweb.com/spring에서-yaml-파일-데이터-객체에-매핑하여-로드하기/

// http://fabiomaffioletti.me/blog/2016/12/20/spring-configuration-properties-handle-deprecated-locations/

// https://github.com/fabiomaffioletti/spring-application-properties/tree/master/src/main/java/me/fabiomaffioletti

// https://stackoverflow.com/questions/37974776/spring-boot-load-multiple-yaml-files

// https://mdeinum.github.io/2018-07-04-PropertySource-with-yaml-files/