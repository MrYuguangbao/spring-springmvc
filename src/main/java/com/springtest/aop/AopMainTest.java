package com.springtest.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author admin
 * @desc
 * @date 2019/7/17 23:24
 */
public class AopMainTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        TestBean bean = (TestBean) context.getBean("testBean");
        bean.test();

    }
}
