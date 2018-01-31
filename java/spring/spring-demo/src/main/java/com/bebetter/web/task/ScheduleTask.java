package com.bebetter.web.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduleTask {
    /**
     * 秒 分 时 一周第几天 一月第几天 月
     */
    @Scheduled(cron = "0 * * * * *")
    public void task() {
        System.out.println("【定时任务】 >>> 使用Spring的Schedule定时任务：" + new Date());
    }
}
