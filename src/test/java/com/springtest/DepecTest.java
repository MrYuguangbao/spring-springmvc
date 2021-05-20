package com.springtest;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author admin
 * @desc
 * @date 2019/7/17 22:23
 */
public class DepecTest {

    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleConstructor() throws Throwable {
        try {
            new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        } catch (Exception e) {
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }
}
