package com.springtest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author admin
 * @desc
 * @date 2019/7/23 10:35
 */
public class JdkProxyExam implements InvocationHandler {

    //真实对象
    private Object target = null;

    /**
     * 建立代理对象和真实对象的代理关系，返回代理对象
     *
     * @param target
     * @return
     */
    public Object bind(Object target) {
        this.target = target;
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return proxy;
    }

    /**
     * @param proxy  代理对象
     * @param method 当前调度方法
     * @param args   方法参数
     * @return 返回代理结果
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑");
        System.out.println("调用真实对象之前");
        Object obj = method.invoke(target, args);
        System.out.println("调用真实对象之后");
        return obj;
    }
}
