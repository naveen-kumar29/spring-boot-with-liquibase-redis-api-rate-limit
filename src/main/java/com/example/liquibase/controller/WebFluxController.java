package com.example.liquibase.controller;

import com.example.liquibase.component.QuartzScheduler;
import com.example.liquibase.config.QuartzConfig;
import com.example.liquibase.model.WebFlux;
import org.apache.tomcat.util.digester.ArrayStack;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class WebFluxController {

    @Autowired
    public Scheduler scheduler;

    @GetMapping("/api/hello")
    public List<WebFlux> getHello() throws Exception {
        Thread.sleep(2000);
        return  Arrays.asList(
                new WebFlux("1","Process 1"),
                new WebFlux("2","Process 2"),
                new WebFlux("3","Process 3"),
                new WebFlux("4","Process 4")
        );
    }

    @GetMapping("/job-schedule")
    public String jobScheduler() throws Exception {

        try {
            JobDetail jobDetail = JobBuilder.newJob(QuartzScheduler.class)
                    .withIdentity("quartzJob")
                    .storeDurably()
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .forJob("quartzJob")
                    .withIdentity("quartzTrigger")
                    .withSchedule(org.quartz.SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(10)
                            .repeatForever())
                    .build();
            // Schedule the job with the trigger
            scheduler.scheduleJob(jobDetail, trigger);

           return "Job Scheduler Successfully";
        }catch (Exception e){
            e.printStackTrace();
            return "Job Scheduler Failed"+e.getMessage();

        }

    }
}
