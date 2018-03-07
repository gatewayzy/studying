package com.bebetter.springbootmvcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication  //相当于@Configuration、@EnableAutoConfiguration、@ComponentScan。Sb自动加载本类并有默认设置
//@ComponentScan("com.bebetter.springbootmvcdemo")  //扫描同级包有效
@EnableTransactionManagement // 开启事务支持
@EnableAspectJAutoProxy // 开启AOP代理
@EnableScheduling // 开启定时任务
@EnableAsync  // 开启异步多线程服务
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
