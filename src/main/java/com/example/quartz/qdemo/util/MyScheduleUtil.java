package com.example.quartz.qdemo.util;

import sun.applet.Main;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 任务调度工具类
 * @program: qdemo
 * @author: chsm
 * @create: 2018-09-26 14:13
 **/
public class MyScheduleUtil {

    private String str = "0 * * * * ?";

    private static final String SUFFIX = " * * ?";

    /**
     * 根据录入时间生成cron表达式
     * 目前该方法默认每天运行，后续将会更新，使得该方法更加自定义话
     * @param localDateTime 时间
     * @return  cron表达式
     */
    public static String generateCronExpression(LocalDateTime localDateTime) {
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        return second + " " + minute + " " + hour + SUFFIX;
    }

    /**
     * 将Date转换为LocalDateTime
     * @return  LocalDateTime
     */
    private static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * 测试cron生成器
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(generateCronExpression(dateToLocalDateTime(new Date())));
    }

}
