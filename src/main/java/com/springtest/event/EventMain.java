package com.springtest.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author admin
 * @date 2020/4/2 22:10
 */
public class EventMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        CustomEvent customEvent = new CustomEvent(context);
        context.publishEvent(customEvent);

    }


}
