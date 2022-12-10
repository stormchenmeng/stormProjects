package com.wind.springboot.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author cmm
 */
@Component
public class TaskDemo {

    private static final Logger logger = LoggerFactory.getLogger(TaskDemo.class);


    /**
     * 每隔2秒钟执行一次该定时任务：输出当前时间
     */
    //@Scheduled(cron = "*/2 * * * * *")
    public void taskForTime() {
        System.out.println("==当前时间==" + new Date());
    }

}
