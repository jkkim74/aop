package com.example.aop2.order.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* *..*Service.*(..))")
    public void allService(){};

    @Pointcut("execution(* com.example.aop2..*(..))")
    public void allOrder(){};

    @Pointcut("allService() && allOrder()")
    public void orderAndAllService(){};


}
