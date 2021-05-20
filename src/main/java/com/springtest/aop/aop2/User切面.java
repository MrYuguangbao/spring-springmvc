package com.springtest.aop.aop2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author admin
 * @date 2019/8/6 18:50
 */
@Aspect
public class User切面 {

    @DeclareParents(value = "com.springtest.aop.aop2.AOP实现类+", defaultImpl = AOP验证器实现类.class)
    public AOP验证器 aop;

    @Before("execution(* com.springtest.aop.aop2.AOP实现类.print(..)) && args(userP,sortP)")
    public void ubefore(User实体类 userP, int sortP) {
        System.out.println("ubefore,传递的参数是：" + userP.getName() + ",排序参数：" + sortP);
    }

    @After("execution(* com.springtest.aop.aop2.AOP实现类.print(..))")
    public void uafter() {
        System.out.println("uafter");
    }

    @AfterReturning("execution(* com.springtest.aop.aop2.AOP实现类.print(..))")
    public void uafterReturning() {
        System.out.println("uafterReturning");
    }

    @AfterThrowing("execution(* com.springtest.aop.aop2.AOP实现类.print(..))")
    public void uafterThrowing() {
        System.out.println("uafterThrowing");
    }

    @Around("execution(* com.springtest.aop.aop2.AOP实现类.print(..))")
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
