package com.example.quartz.qdemo.controller;

import com.example.quartz.qdemo.test.Hello;
import com.example.quartz.qdemo.test.Test;
import com.example.quartz.qdemo.util.MyScheduleUtil;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: qdemo
 * @author: chsm
 * @create: 2018-09-26 09:13
 **/
@RestController
public class SchedulerController {

    private final SchedulerFactoryBean schedulerFactoryBean;

    private final AtomicInteger atomicInteger;

    @Autowired
    public SchedulerController(SchedulerFactoryBean schedulerFactoryBean, AtomicInteger atomicInteger) {
        this.schedulerFactoryBean = schedulerFactoryBean;
        this.atomicInteger = atomicInteger;
    }

    @PostMapping("/test")
    public String test(@RequestBody Test test) throws Exception {
        // 调度器
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        // 构建工作信息
        JobDetail jobDetail = JobBuilder
                // 创建工作
                .newJob(Hello.class)
                // 设置唯一标识，此处暂时用线程安全的integer代替
                .withIdentity(String.valueOf(atomicInteger.incrementAndGet()))
                // 设置工作数据
                .usingJobData("hello", test.getName())
                .build();
        // 获取调度规则
        String cronExpression = MyScheduleUtil.generateCronExpression(test.getLocalDateTime());
        // 构建触发器
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                // 配置调度规则
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                .build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
        return "调度成功，调度规则：" + cronExpression;
    }
}
