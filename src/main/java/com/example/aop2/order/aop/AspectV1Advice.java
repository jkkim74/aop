package com.example.aop2.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class AspectV1Advice {

    @Around("execution(* com.example.aop2.order..*(..))")
    public Object doLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        log.info("[log] {}",proceedingJoinPoint.getSignature());
       Object result =  proceedingJoinPoint.proceed();
       return result;
    }

}
