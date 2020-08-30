package com.tarun.window.service.servicecheck.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WindowServiceCheckScheduler {

    private  static  final  Logger log = LoggerFactory.getLogger(ScheduledTask.class);

   @Scheduled(fixedRate = 10000)
    public void checkService() {
        String serviceName = "myService";

        try {
            Process process = new ProcessBuilder("C:\\Windows\\System32\\sc.exe", "query" , "MongoDB" ).start();
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line;
            String scOutput = "";

            // Append the buffer lines into one string
            while ((line = br.readLine()) != null) {
                scOutput +=  line + "\n" ;
            }

            if (scOutput.contains("STATE")) {
                if (scOutput.contains("RUNNING")) {
                    log.info("Service running");
                } else {
                    log.info("Service stopped");
                }
            } else {
                log.info("Unknown service");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
