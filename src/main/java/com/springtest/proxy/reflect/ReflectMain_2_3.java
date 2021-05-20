package com.springtest.proxy.reflect;

import java.lang.reflect.InvocationTargetException;

/**
 * @author admin
 * @desc
 * @date 2019/7/23 10:10
 */
public class ReflectMain_2_3 {
    public static void main(String[] args) {
        Reflect_2_3 object = null;

        try {
            object = (Reflect_2_3) Class.forName("com.springtest.proxy.reflect.Reflect_2_3").getConstructor(String.class).newInstance("spring");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        object.sayHello();

    }

}
