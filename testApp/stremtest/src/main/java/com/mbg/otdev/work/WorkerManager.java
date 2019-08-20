package com.mbg.otdev.work;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkerManager {

    public void execute() {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Runnable worker = new StreamWorker(makeCommand());
        //worker.setCommand(makeCommand());
        executor.submit(worker);
        executor.shutdown();

        // try{
        //     TimeUnit.SECONDS.sleep(5);
        // } catch(Exception e) {}
        
        // System.out.println("Shut down now Start");
        // executor.shutdownNow();
    }

    private String makeUrl() {
        String getUrl;
        getUrl = "http://192.168.203.112:8080/hello/ss/SuicideSquad.m3u8";
        
        return getUrl;
    }

    private List<String> makeCommand() {

        //ffmpeg -i http:localhost:8080/hello/goldeneye.m3u8 -c copy -bsf:a aac_adtstoasc output.mp4
        String saveDir = "/Users/lamhirh/Downloads";
        String svveFileName = "output_"+getCurrentTime()+".mp4";
        String saveFile = saveDir+"/"+svveFileName;

        List<String> command = new ArrayList<String>();
        command.add("ffmpeg");
        command.add("-i");
        command.add(makeUrl());
        command.add("-c");
        command.add("copy");
        command.add(saveFile);
        
        // List<String> command = new ArrayList<String>();
        // command.add("ffmpeg");
        // command.add("-i");
        // command.add(makeUrl());
        // command.add("-c");
        // command.add("copy");
        // command.add("-bsf:a");
        // command.add("aac_adtstoasc");
        // command.add(saveFile);

        return command;

    }

    private String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String nowString = now.format(dateTimeFormatter);   // 결과 : 2016년 4월 2일 오전 1시 4분

        return nowString;
    }
}