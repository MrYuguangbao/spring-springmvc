package com.springtest.springaop_11_1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 22:59
 */
public class ProxyBeanUtil implements InvocationHandler {

    private Object target;

    private Interceptor interceptor = null;

    public static Object getBean(Object target, Interceptor interceptor) {
        ProxyBeanUtil _this = new ProxyBeanUtil();
        _this.target = target;
        _this.interceptor = interceptor;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), _this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object retObje = null;
        boolean exFlag = false;
        interceptor.befor(target);
        try {
            retObje = method.invoke(target, args);
        } catch (Exception e) {
            exFlag = true;
            //e.printStackTrace();
        } finally {
            interceptor.after(target);
        }
        if (exFlag) {
            interceptor.afterThrowing(target);
        } else {
            interceptor.afterReturning(target);
        }
        return retObje;
    }
}
