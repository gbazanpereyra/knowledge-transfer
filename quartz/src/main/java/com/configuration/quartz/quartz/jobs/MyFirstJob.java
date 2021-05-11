package com.configuration.quartz.quartz.jobs;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
@DisallowConcurrentExecution
public class MyFirstJob implements Job {


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("==========================");
        System.out.println("Hola mundo desde mi primer joooob");
        System.out.println("==========================");
    }
}
