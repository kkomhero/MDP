package com.mbg.otdev.work;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class StreamDownload {


    public void start() {

        //ffmpeg.exe -i "C:\Users\hojin\Downloads\FFMPEG TEST\index.m3u8" test.ts
        List<String> command = new ArrayList<String>();
        command.add("bash");
        command.add("-c");
        command.add("echo $PPID ; while true; do ls /Users/hoya/Music; sleep 1; done;");

        ExecutorService pool = Executors.newSingleThreadExecutor();

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(command);

        try {

            Process process = processBuilder.start();

            System.out.println("process ping...");
            ProcessReadTask task = new ProcessReadTask(process.getInputStream());
            Future<List<String>> future = pool.submit(task);

            // no block, can do other tasks here
            System.out.println("process task1...");
            System.out.println("process task2...");

            List<String> result = future.get(5, TimeUnit.SECONDS);
            for (String s : result) {
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }

    private static class ProcessReadTask implements Callable<List<String>> {

        private InputStream inputStream;

        public ProcessReadTask(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public List<String> call() {
            //return new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.toList());
            return null;
        }
    }

}