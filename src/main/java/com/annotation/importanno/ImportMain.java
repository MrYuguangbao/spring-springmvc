package com.annotation.importanno;

import com.annotation.conditional.ConditionalConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.importanno
 * @author:admin
 * @createTime 9月 18 2021 23:17:37
 */
public class ImportMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConditionalConfig.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }

        RainBow bean = ac.getBean(RainBow.class);
        System.out.println(bean);

    }

}
