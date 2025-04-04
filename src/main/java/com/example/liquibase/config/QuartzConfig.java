package com.example.liquibase.config;

import com.example.liquibase.component.QuartzScheduler;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

  /*  @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(QuartzScheduler.class)
                .withIdentity("quartzJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger jobTrigger(JobDetail jobDetail){
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity("quartzTrigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10)
                        .repeatForever())
                .build();
    }*/
}
