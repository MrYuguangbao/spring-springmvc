package com.springtest.proxy.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author admin
 * @desc
 * @date 2019/7/23 10:18
 */
public class ReflectMain_2_6 {
    public static void main(String[] args) {
        try {
            Reflect_2_1 target = null;
            target = (Reflect_2_1) Class.forName("com.springtest.proxy.reflect.Reflect_2_1").newInstance();
            Method method = target.getClass().getMethod("sayHello", String.class);
            method.invoke(target, "软件设计模式");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
