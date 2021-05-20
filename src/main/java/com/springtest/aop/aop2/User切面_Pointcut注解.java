package com.springtest.aop.aop2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author admin
 * @date 2019/8/6 18:50
 */
@Aspect
public class User切面_Pointcut注解 {

    @Pointcut("execution(* com.springtest.aop.aop2.*.print(..))")
    public void print() {
    }

    @Before("print()")
    public void ubefore() {
        System.out.println("ubefore");
    }

    @After("print()")
    public void uafter() {
        System.out.println("uafter");
    }

    @AfterReturning("print()")
    public void uafterReturning() {
        System.out.println("uafterReturning");
    }

    @AfterThrowing("print()")
    public void uafterThrowing() {
        System.out.println("uafterThrowing");
    }

    @Around("print()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("around before..........");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around after..........");
    }

}
