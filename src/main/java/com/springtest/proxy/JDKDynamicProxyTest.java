package com.springtest.proxy;

/**
 * @author admin
 * @desc
 * @date 2019/7/17 23:56
 */
public class JDKDynamicProxyTest {

    public static void main(String[] args) {

        JdkProxyExam proxy = new JdkProxyExam();
        HelloWorldImpl target = new HelloWorldImpl();
        HelloWorld helloWorld = (HelloWorld) proxy.bind(target);
        helloWorld.say();


    }

}
