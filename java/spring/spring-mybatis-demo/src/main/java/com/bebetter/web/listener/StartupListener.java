package com.bebetter.web.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupListener implements ApplicationListener{
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.print("【监听器】 >>> 监听到项目发布事件。事件属于项目重启：");
        System.out.println(applicationEvent instanceof ContextRefreshedEvent);
    }
}
