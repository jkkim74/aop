package com.example.aop2.exam.aop;

import com.example.aop2.exam.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class RetryAspect {

    @Around("@annotation(retry)")
    public Object doRetry(ProceedingJoinPoint proceedingJoinPoint, Retry retry) throws Throwable {
        log.info("[retry] {} retry={}",proceedingJoinPoint.getSignature(),retry);
        int maxRetry = retry.value();
        Exception exceptionHoler = null;
        for(int retryCount = 1; retryCount < maxRetry; retryCount++){
            try {
                log.info("[retry] try count={}",retryCount+"/"+maxRetry);
                return proceedingJoinPoint.proceed();
            } catch (Exception e) {
                exceptionHoler = e;
            }
        }
        throw exceptionHoler;
    }
}
