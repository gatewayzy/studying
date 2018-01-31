package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dell on 2017/7/19.
 */
@RestController  // web的注解，将@Controller和@ResponseBody进行了功能合并
@EnableAutoConfiguration  // 自动配置web容器等bean
public class _01BootWeb {
    @RequestMapping("/")
    String home() {
        return "Hello World From Home";
    }

    public static void main(String[] args) {
        System.out.println("如果使用这种方式发布，就需要@EnableAutoConfiguration来自动配置一个容器");
        SpringApplication.run(_01BootWeb.class, args);
    }


}
