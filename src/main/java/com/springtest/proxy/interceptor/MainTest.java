package com.springtest.proxy.interceptor;

import com.springtest.proxy.HelloWorld;
import com.springtest.proxy.HelloWorldImpl;
import lombok.val;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author admin
 * @desc
 * @date 2019/7/23 11:19
 */
public class MainTest {

    public static void main(String[] args) {
        HelloWorld proxy1 = (HelloWorld) JdkProxyInterceptor.bind(new HelloWorldImpl(),
                "com.springtest.proxy.interceptor.InterceptorImpl1");
        HelloWorld proxy2 = (HelloWorld) JdkProxyInterceptor.bind(proxy1,
                "com.springtest.proxy.interceptor.InterceptorImpl2");
        HelloWorld proxy3 = (HelloWorld) JdkProxyInterceptor.bind(proxy2,
                "com.springtest.proxy.interceptor.InterceptorImpl3");
        proxy3.say();


    }
}
