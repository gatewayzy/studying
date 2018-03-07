package com.bebetter.springdemo.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async
    public void task1(int i) {
        System.out.println(String.format("\n=======\n执行异步任务：i=%d，%s\n", i, Thread.currentThread().getName()));
    }

    @Async
    public void task2(int i) {
        System.out.println(String.format("\n=======\n执行异步任务+1：i=%d，%s\n", ++i, Thread.currentThread().getName()));
    }


}
