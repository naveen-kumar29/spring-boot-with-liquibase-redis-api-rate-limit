package com.example.liquibase.component;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.springframework.stereotype.Component;

import java.sql.Time;

@Component
public class QuartzScheduler implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("Executing Quartz Job: " + new java.sql.Timestamp(currentTimeMillis));

    }


}
