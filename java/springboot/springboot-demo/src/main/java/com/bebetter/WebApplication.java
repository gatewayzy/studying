package com.bebetter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 运行main方法启动一个普通的微服务，可以看到Springboot默认提供的bean
 */

@RestController  // web的注解，将@Controller和@ResponseBody进行了功能合并
@EnableAutoConfiguration  // 自动配置web容器等bean
public class WebApplication {

    @RequestMapping("/")
    String home() {
        return "浏览器显示：Hello World From Home，类似于JFinal的renderText，文本自动包装";
    }

    public static void main(String[] args) {
        System.out.println("如果使用这种方式发布，就需要@EnableAutoConfiguration来自动配置一个容器");
        System.out.println("运行main()，访问 http://127.0.0.1:1111/  端口来自自动读取的配置文件");
        SpringApplication.run(WebApplication.class, args);
    }

}
