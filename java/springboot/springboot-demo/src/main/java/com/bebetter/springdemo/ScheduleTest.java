package com.bebetter.springdemo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleTest {

    @Scheduled(fixedRate = 5000)
    public void task1() {
        System.out.println(String.format("\n=========\n定时任务：每隔%d秒输出一次\n", 5));
    }

    @Scheduled(cron = "0 * * * * *")
    public void task2() {
        System.out.println(String.format("\n=========\n定时任务：每隔%d秒输出一次\n", 10));
    }
}
