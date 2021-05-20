package com.springtest.aop.jingdian;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

/**
 * @author admin
 * @date 2020/1/7 16:31
 */
@Aspect
@Order(3)
public class Aspect3 {
    @Pointcut("execution(* com.springtest.aop.jingdian.MultiBeanImpl.testMultiBean(..))")
    public void print() {
    }

    @Before("print()")
    public void ubefore() {
        System.out.println("ubefore3");
    }

    @After("print()")
    public void uafter() {
        System.out.println("uafter3");
    }

    @AfterReturning("print()")
    public void uafterReturning() {
        System.out.println("uafterReturning3");
    }

    @AfterThrowing("print()")
    public void uafterThrowing() {
        System.out.println("uafterThrowing3");
    }

    /*@Around("print()")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("around before..........");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around after..........");
    }*/

}
