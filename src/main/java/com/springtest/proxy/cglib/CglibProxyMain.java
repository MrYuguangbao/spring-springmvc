package com.springtest.proxy.cglib;

import com.springtest.proxy.HelloWorldImpl;

/**
 * @author admin
 * @desc
 * @date 2019/7/23 10:55
 */
public class CglibProxyMain {
    public static void main(String[] args) {
        CglibProxyExam proxy = new CglibProxyExam();
        MyHello myHello = (MyHello) proxy.getCglibProxy(MyHello.class);
        myHello.say();
    }
}
