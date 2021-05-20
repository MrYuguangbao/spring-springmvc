package com.springtest.mybatis.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 10:43
 */
public class AnnotationTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PojoConfig.class);
        User user = (User) context.getBean(User.class);
        System.out.println(user.getId());

    }
}
