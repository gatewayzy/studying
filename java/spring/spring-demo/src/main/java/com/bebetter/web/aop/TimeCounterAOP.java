package com.bebetter.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class TimeCounterAOP {
    // 切面有@Around、@Before、@After等

    @Around("execution(* com.bebetter.web.controller..*.*(..))")
    public Object counter(ProceedingJoinPoint point) {
        // 从切面获取相关信息
        String clazz = point.getTarget().getClass().getName();
        String method = point.getSignature().getName();
        Object[] args = point.getArgs();

        // 记录方法运行耗时
        long time = System.currentTimeMillis();
        Object object = null;
        try {
            object = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        time = System.currentTimeMillis() - time;
        System.err.print(String.format("【全局计时切面】 >>> 方法名：%s 耗时：%d", clazz + "." + method, time));
        Arrays.asList(args).forEach(t -> System.err.print(" " + t));
        System.err.println();

        return object;
    }

}
