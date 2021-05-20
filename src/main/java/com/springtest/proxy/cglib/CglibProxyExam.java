package com.springtest.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author admin
 * @desc
 * @date 2019/7/23 10:50
 */
public class CglibProxyExam implements MethodInterceptor {

    /**
     * 生成cglib代理对象
     *
     * @param c Class类
     * @return Class类的cglib代理对象
     */
    public Object getCglibProxy(Class c) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(c);
        enhancer.setCallback(this);
        Object object = enhancer.create();
        return object;
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用真实对象之前");
        Object result = methodProxy.invokeSuper(proxy, args);
        System.out.println("调用真实对象之后");
        return result;
    }
}
