package com.example.aop2.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AspectV6Advice {



    @Before("com.example.aop2.order.aop.Pointcuts.allService()")
    public void doBefore(JoinPoint joinPoint){
        log.info("[Before] {} ",joinPoint.getSignature());
    }

}
