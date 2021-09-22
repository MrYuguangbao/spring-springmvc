package com.annotation.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.lifecycle
 * @author:admin
 * @createTime 9月 19 2021 08:41:07
 */
public class LifecycleMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifecycleConfig.class);
        System.out.println(ac.getBean("car"));

        ConfigurableEnvironment environment = ac.getEnvironment();
        System.out.println("从环境变量中读取1：" + environment.getProperty("car.nickname"));
        System.out.println("从环境变量中读取2：" + environment.getProperty("car2.nickname"));
        ac.close();

    }
}
