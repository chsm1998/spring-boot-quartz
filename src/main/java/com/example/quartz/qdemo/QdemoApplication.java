package com.example.quartz.qdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@EnableAsync
@EnableSwagger2
@SpringBootApplication
public class QdemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(QdemoApplication.class, args);
    }
}
