package com.bebetter.springdemo.async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTest {
    @Autowired
    private AsyncService asyncService;

    @Test
    public void taskTest(){
        for (int i = 0; i < 10; i++) {
            asyncService.task1(i);
            asyncService.task2(i);
        }
    }

}
