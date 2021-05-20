package com.springtest.aop.aop1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author admin
 * @date 2019/8/6 18:09
 */
public class ProxyBeanUtil implements InvocationHandler {

    private Object obj;
    private Interceptor interceptor = null;

    //绑定真实对象
    public static Object getBean(Object obj, Interceptor interceptor) {
        ProxyBeanUtil proxyBeanUtil = new ProxyBeanUtil();
        proxyBeanUtil.obj = obj;
        proxyBeanUtil.interceptor = interceptor;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), proxyBeanUtil);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnObj = null;
        boolean exceptionFlag = false;
        interceptor.before(obj);
        try {
            returnObj = method.invoke(obj, args);
        } catch (Exception e) {
            exceptionFlag = true;
            e.printStackTrace();
        } finally {
            interceptor.after(obj);
        }
        if (exceptionFlag) {
            interceptor.afterThrowing(obj);
        } else {
            interceptor.afterReturning(obj);
        }
        return returnObj;
    }
}
