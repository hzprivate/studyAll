package com.mydemo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * @author hz
 * @Description:
 * @create 2020-04-25
 */
@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* com.mydemo.aop.dao..*.*(..))")
    public  void  pointcut(){

    }

    @Pointcut("within(com.mydemo.aop.dao..*)")
    private void inTrading() {}


    @Pointcut("this(com.mydemo.aop.dao.TestDaoImpl)")
    private void testThis() {}

    @Pointcut("args(java.lang.String)")
    private void testArgs() {}

    @Before("testThis()")
    public void test(){

        System.out.println("before");
    }
}
