package com.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.aop
 * @author:admin
 * @createTime 9月 20 2021 18:18:03
 */
public class AopMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AopConfig.class);
        MathCalculator mathCalculator = ac.getBean(MathCalculator.class);
        double res = mathCalculator.div(4, 2);
        System.out.println("res = " + res);

        ac.close();

    }
}
