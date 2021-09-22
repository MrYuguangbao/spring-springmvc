package com.annotation.autowire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.autowire
 * @author:admin
 * @createTime 9月 19 2021 16:45:28
 */
public class AutowiredMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutowiredConfig.class);
        System.out.println("ac = " + ac);
        SpringService bean = ac.getBean(SpringService.class);
        System.out.println(bean);

        Boss boss = ac.getBean(Boss.class);
        System.out.println("标注在构造方法上：" + boss);

        Car car = ac.getBean(Car.class);
        System.out.println("从容器中获取" + car);

        Teacher teacher = ac.getBean(Teacher.class);
        System.out.println("@Bean注解上：" + teacher);
    }
}
