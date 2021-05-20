package com.springtest.reflect;

/**
 * @author admin
 * @date 2019/8/6 16:29
 */
public class MyReflect1 {
    public String name;

    public MyReflect1(String name) {
        this.name = name;
    }

    public void say(String name) {
        System.out.println("hello,:" + name);
    }

    public static MyReflect1 getInstan() {
        MyReflect1 result = null;
        try {
            result = (MyReflect1) Class.forName("com.springtest.reflect.MyReflect1").getConstructor(String.class).newInstance("ddd");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        MyReflect1 obj = getInstan();
        obj.say(obj.name);
    }


}
