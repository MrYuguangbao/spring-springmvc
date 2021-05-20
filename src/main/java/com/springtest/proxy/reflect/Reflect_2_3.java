package com.springtest.proxy.reflect;

/**
 * @author admin
 * @desc
 * @date 2019/7/23 10:09
 */
public class Reflect_2_3 {
    private String name;

    public Reflect_2_3(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("hello," + name);
    }
}
