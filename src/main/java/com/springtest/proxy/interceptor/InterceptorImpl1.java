package com.springtest.proxy.interceptor;

import java.lang.reflect.Method;

/**
 * @author admin
 * @desc
 * @date 2019/7/23 11:05
 */
public class InterceptorImpl1 implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("11111 before:反射方法前逻辑");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("11111 around:取代被代理对象的方法");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("11111 after:反射方法后逻辑");
    }
}
