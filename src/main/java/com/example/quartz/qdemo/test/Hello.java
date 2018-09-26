package com.example.quartz.qdemo.test;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 实现job接口，当执行任务时会调用execute方法
 * @program: qdemo
 * @author: chsm
 * @create: 2018-09-25 10:23
 **/
public class Hello implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        // 获取工作数据map
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        System.out.println(jobDataMap.get("hello"));
    }
}
