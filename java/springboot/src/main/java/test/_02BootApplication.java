package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * Created by dell on 2017/7/19.
 */

@SpringBootApplication  //
public class _02BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(_02BootApplication.class, args);
    }

    public void commondLineRunner(ApplicationContext ctx) {
        System.out.println("Spring Boot 的bean");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName: beanNames
             ) {
            System.out.println(beanName);


        }
        return ;
    }


}
