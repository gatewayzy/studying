package com.bebetter.springbootmybatisdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisDemoApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println("加载src所有的bean，在这里测试功能。");
    }

}
