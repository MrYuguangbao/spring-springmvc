package com.springtest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author admin
 * @desc
 * @date 2019/7/17 23:53
 */
public class MyInvocation implements InvocationHandler {

    private Object target;

    public MyInvocation(Object target) {
        super();
        this.target = target;
    }

    public Object getProxy() {
        Object result = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), this);
        return result;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---------- before ----------");
        Object result = method.invoke(target, args);
        System.out.println("---------- after ----------");
        return result;
    }
}
