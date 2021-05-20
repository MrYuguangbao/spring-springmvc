package com.springtest.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author admin
 * @desc
 * @date 2019/7/18 0:01
 */
public class EnchancerDemo {

    public void test() {
        System.out.println("------- tst- --------");
    }

    private static class MethodInterceptorImpl implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("方法 " + method + " 调用之前");
            Object result = methodProxy.invoke(o, objects);
            System.out.println("方法 " + method + " 调用之后");
            return result;
        }
    }


    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EnchancerDemo.class);
        enhancer.setCallback(new MethodInterceptorImpl());

        EnchancerDemo demo = (EnchancerDemo) enhancer.create();
        demo.test();
        System.out.println(demo);

    }


}
