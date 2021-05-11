package com.configuration.quartz.quartz;

import com.configuration.quartz.quartz.jobs.MyFirstJob;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzSubmitJobs {


    @Bean(name = "myFirstJobJob")
    public JobDetailFactoryBean jobMyFirstJob() {
        return QuartzConfig.createJobDetail(MyFirstJob.class, "My First Job");
    }

    @Bean(name = "myFirstJobTrigger")
    public SimpleTriggerFactoryBean triggerMyFirstJob(@Qualifier("myFirstJobJob") JobDetail jobDetail) {
        return QuartzConfig.createTrigger(jobDetail, 10000, SimpleTrigger.REPEAT_INDEFINITELY, "My First Job");
    }

}
