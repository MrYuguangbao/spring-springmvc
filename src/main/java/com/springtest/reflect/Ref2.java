package com.springtest.reflect;

import org.springframework.beans.factory.BeanFactory;

import java.lang.reflect.Method;

/**
 * @author admin
 * @date 2019/8/6 16:35
 */
public class Ref2 {

    public Object getMethod() throws Exception {
        Object result = null;
        Object myObj = (MyReflect1) Class.forName("com.springtest.reflect.MyReflect1").getConstructor(String.class).newInstance("ddd");
        Method say = myObj.getClass().getMethod("say", String.class);
        result = say.invoke(myObj, ((MyReflect1) myObj).name);
        return result;
    }

    public static void main(String[] args) throws Exception {
        Ref2 ref2 = new Ref2();
        ref2.getMethod();
    }

}
