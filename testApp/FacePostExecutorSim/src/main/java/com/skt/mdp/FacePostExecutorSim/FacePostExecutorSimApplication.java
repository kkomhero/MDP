package com.skt.mdp.FacePostExecutorSim;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FacePostExecutorSimApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacePostExecutorSimApplication.class, args);

		// String filefulpath = "/home/mdp/deepmeta_data/deepmeta_data/face/raw/12345/suicide_squad_raw_face.csv";
		// int epos = filefulpath.lastIndexOf(".");
		// int spos = filefulpath.lastIndexOf("/");
        // String fileName = filefulpath.substring(spos+1, filefulpath.length());
        
		
		// //Path path = Paths.get(filefulpath);
		// //String fileName = path.getFileName().toString();

        // System.out.println("faceRawWork start => "+filefulpath +"::"+fileName);
	}

}
