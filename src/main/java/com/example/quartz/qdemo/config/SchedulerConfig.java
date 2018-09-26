package com.example.quartz.qdemo.config;

import com.example.quartz.qdemo.test.Hello;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.impl.JobDetailImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: qdemo
 * @author: chsm
 * @create: 2018-09-25 09:56
 **/
@Configuration
public class SchedulerConfig {

    @Bean
    public Hello hello() {
        return new Hello();
    }

    /**
     * 全局调度器
     * @return  SchedulerFactoryBean
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        return schedulerFactoryBean;
    }

    @Bean
    public AtomicInteger integer() {
        return new AtomicInteger();
    }
}
