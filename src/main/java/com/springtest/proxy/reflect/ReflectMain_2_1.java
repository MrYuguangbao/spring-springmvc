package com.springtest.proxy.reflect;

/**
 * @author admin
 * @desc
 * @date 2019/7/23 10:03
 */
public class ReflectMain_2_1 {
    public static void main(String[] args) {
        Reflect_2_1 object = null;
        try {
            Class<?> reflectObject = Class.forName("com.springtest.proxy.reflect.Reflect_2_1");
            object = (Reflect_2_1) reflectObject.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        object.sayHello("java");


    }
}
