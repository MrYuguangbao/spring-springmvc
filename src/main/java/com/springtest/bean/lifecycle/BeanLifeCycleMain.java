package com.springtest.bean.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author admin
 * @desc
 * @date 2019/7/25 23:44
 */
public class BeanLifeCycleMain {
    public static void main(String[] args) {
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/applicationContext.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Juice juice = (Juice) context.getBean("juice");
        /*Juice juice1 = (Juice) context.getBean("juice");
        System.out.println(juice == juice1);*/
        juice.show();
        context.close();

    }
}
