package com.example.aop2;

import com.example.aop2.order.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@Import(BeanTest.ParameterAspect.class)
@SpringBootTest
public class BeanTest {

    @Autowired
    OrderService orderService;

    @Test
    void success(){
        orderService.orderItem("itemId2");
    }

    @Aspect
    static class BeanAspect{

        @Around("bean(orderService) || bean(*Repository)")
        public Object doLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
            log.info("[doLog] ={}",proceedingJoinPoint.getSignature());
            return proceedingJoinPoint.proceed();
        }
    }

    @Aspect
    static class ParameterAspect{

        @Pointcut("execution(* com.example.aop2.order..*.*(..))")
        private void allOrder(){}

        @Around("allOrder() && args(arg, ..)")
        public Object doLog2(ProceedingJoinPoint proceedingJoinPoint, Object arg) throws Throwable {
            log.info("[doLog2]={}, arg={}",proceedingJoinPoint.getSignature(),arg);
            return proceedingJoinPoint.proceed();
        }

        @Before("allOrder() && args(arg, ..)")
        public void doLog3(String arg){
            log.info("[doLog3] arg={}",arg);
        }

        @Before("allOrder() && this(obj)")
        public void thisArgs(JoinPoint joinPoint, OrderService obj){
            log.info("[this]{},obj={}",joinPoint.getSignature(),obj.getClass());
        }

        @Before("allOrder() && target(obj)")
        public void targetArgs(JoinPoint joinPoint, OrderService obj){
            log.info("[target]{},obj={}",joinPoint.getSignature(),obj.getClass());
        }
    }
}
