package com.springtest.aop.aop1;

/**
 * @author admin
 * @date 2019/8/6 18:07
 */
public class RoleInterceptor implements Interceptor {
    @Override
    public void before(Object object) {
        System.out.println("before");
    }

    @Override
    public void after(Object object) {
        System.out.println("after");
    }

    @Override
    public void afterReturning(Object object) {
        System.out.println("afterReturning");
    }

    @Override
    public void afterThrowing(Object object) {
        System.out.println("afterThrowing");
    }
}
