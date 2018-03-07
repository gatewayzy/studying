package com.bebetter.springdemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component  // 作为一个bean
public class AOPTest {

    @Around("execution (* com.bebetter..*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        String classFullName = proceedingJoinPoint.getTarget().getClass().getName();
        Signature signature = proceedingJoinPoint.getSignature();
        String methodName = signature.getName();
        signature.getDeclaringType();
        long start = System.currentTimeMillis();
        Object ret = null;
        try {
            ret = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long time = System.currentTimeMillis() - start;
        System.out.println(String.format("\n=========\naop统计方法耗时\n%s.%s %sms\n", classFullName, methodName, time));
        return ret;
    }
}
