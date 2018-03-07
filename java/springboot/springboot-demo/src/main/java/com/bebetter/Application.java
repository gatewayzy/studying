package com.bebetter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@SpringBootApplication  //相当于@Configuration、@EnableAutoConfiguration、@ComponentScan。Sb自动加载本类并有默认设置
//@ComponentScan("com.bebetter.mybatisdemo")  //扫描包
@EnableTransactionManagement // 开启事务支持
@EnableAspectJAutoProxy // 开启AOP代理
@EnableScheduling // 开启定时任务
@EnableAsync  // 开启异步多线程服务
public class Application {

    /**
     * 运行main()方法，即为启动一个微服务。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("\n=================启动微服务=========================\n");
        SpringApplication.run(Application.class, args);
    }

    /**
     * 在项目启动时，作为一个bean（名称是方法名）。输出Springboot默认提供的bean
     *
     * @param ctx
     * @return
     */
    @Bean
    public CommandLineRunner commondLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("\n==========================================\n【查看Springboot自带的bean：】");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }

    /**
     * 为项目提供一个线程池
     * @return
     */
    @Bean
    public AsyncTaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("async-thread-");
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        // executor设置拒绝策略、异常处理等等
        return executor;
    }


}
