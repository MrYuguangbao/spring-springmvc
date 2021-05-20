package com.springtest.profile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 17:13
 */
public class StartUpMainTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyJavaConfig.class);
        MyPeopleController controller = context.getBean(MyPeopleController.class);
        controller.queryPeople(5);
        ((AnnotationConfigApplicationContext) context).close();
    }
}
