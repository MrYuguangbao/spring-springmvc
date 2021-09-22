package com.annotation.factorybean;

import com.annotation.conditional.ConditionalConfig;
import com.annotation.importanno.RainBow;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.importanno
 * @author:admin
 * @createTime 9月 18 2021 23:17:37
 */
public class FactoryBeanMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConditionalConfig.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        System.out.println("--------------------- 容器中beanName ---------------------");
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
        Object bean1 = ac.getBean("colorFactoryBean");
        Object bean2 = ac.getBean("&colorFactoryBean");
        System.out.println(bean1);
        System.out.println(bean2);

    }

}
