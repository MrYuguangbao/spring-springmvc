package com.springtest.proxy;

/**
 * @author admin
 * @desc
 * @date 2019/7/23 10:34
 */
public class HelloWorldImpl implements HelloWorld {

    @Override
    public void say() {
        System.out.println("hello world!");
    }
}
