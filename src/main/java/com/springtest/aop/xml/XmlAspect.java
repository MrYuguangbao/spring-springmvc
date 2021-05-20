package com.springtest.aop.xml;

import com.springtest.RoleVO;
import com.springtest.aop.aop2.AOP验证器;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author admin
 * @date 2020/1/7 14:44
 */
public class XmlAspect {

    public AOP验证器 aop;

    public void before(RoleVO roleVO) {
        System.out.println("before:" + roleVO.toString());
    }

    public void after() {
        System.out.println("after");
    }

    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    public void afterReturning() {
        System.out.println("afterReturning");
    }

    public void around(ProceedingJoinPoint joinPoint) {
        System.out.println("---around before----");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("---around after----");
    }
}
