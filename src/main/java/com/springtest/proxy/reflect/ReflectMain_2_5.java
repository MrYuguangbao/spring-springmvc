package com.springtest.proxy.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author admin
 * @desc
 * @date 2019/7/23 10:14
 */
public class ReflectMain_2_5 {

    public static void main(String[] args) {
        Reflect_2_1 target = new Reflect_2_1();
        try {
            Method method = target.getClass().getMethod("sayHello", String.class);
            method.invoke(target, "pattern");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
