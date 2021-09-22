package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.aop
 * @author:admin
 * @createTime 9月 20 2021 17:59:57
 */
@Aspect
public class LogAspect {

    @Pointcut("execution(public double com.aop.MathCalculator.div(int, int))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void logStart(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("@Before -- logStart --,方法名是：" + name + ",参数列表是:" + Arrays.toString(args));
    }

    @After("com.aop.LogAspect.pointcut()")
    public void logEnd(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("@After -- logEnd --,方法名是：" + name);
    }

    @AfterReturning(pointcut = "pointcut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        System.out.println("@AfterReturning -- logReturn --,方法名：" + name + "返回结果是:" + result);
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "exception")
    public void logException(Exception exception) {
        System.out.println("@AfterThrowing -- logException --,异常信息：");
    }
}
