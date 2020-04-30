package com.springboot.demo.springbootdemo.aspect;

import com.springboot.demo.springbootdemo.annotation.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author hz
 * @create 2020-04-08
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.springboot.demo.springbootdemo.annotation.Log)")
    public  void poincount(){
    }

    @Around("poincount()")
    public void around(ProceedingJoinPoint joinPoint){
        System.out.println("开始进入环绕通知：");
        try {
            // 执行方法
            joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        if(method!=null){
            Log annotation = method.getAnnotation(Log.class);
            System.out.println("注解上描述："+annotation.value());
        }
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = ((MethodSignature) joinPoint.getSignature()).getMethod().getName();
        System.out.println("方法名："+className+"."+methodName);

    }
}
