package com.mbg.otdev.work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamWorker implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(StreamWorker.class);

    String downloadUrl;
    String downloadDir;
    String saveDir;
    String saveFileName;
    List<String> execCommand;
    
    public StreamWorker() {

    }

    public StreamWorker(List<String> command) {
        this.execCommand = command;
    }

	@Override
    public void run() {
        // List<String> command = new ArrayList<String>();
        // command.add("bash");
        // command.add("-c");
        // command.add("echo $PPID ; while true; do ls /Users/hoya/Music; sleep 1; done;");
        // ProcessBuilder pb = new ProcessBuilder(command);

        // ffmpeg -i http:localhost:8080/hello/goldeneye.m3u8 -c copy -bsf:a aac_adtstoasc output.mp4
        ProcessBuilder pb = new ProcessBuilder(execCommand);
        pb.redirectOutput(Redirect.INHERIT);
        pb.redirectError(Redirect.INHERIT);

        try {
            Process process = pb.start();
            try {
                Field f = process.getClass().getDeclaredField("pid");
                f.setAccessible(true);
                log.debug("-->{}", f.getLong(process));
                f.setAccessible(false);
            } catch (Exception e) {
                log.error(ExceptionUtils.getStackTrace(e));
            }
            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
      
            while ((line = bufferedReader.readLine()) != null) {
              // output += line + "\n";
                if (!line.isEmpty())
                    log.debug("{}", line);
                
            }
            int exitValue = process.waitFor();
            
            //process.waitFor(20, TimeUnit.SECONDS);
            
            //process.destroy();
      //      log.debug("Exit Value is " + exitValue);
            log.debug("Exit Value is " + exitValue);
      
      
        } catch (IOException e) {
            //log.error(e.getMessage());
            e.printStackTrace();
        } 
        catch (InterruptedException e) {
            System.out.println("InterruptedException receive !!");
            e.printStackTrace();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void setCommand(List<String> cmd) {

    }
}