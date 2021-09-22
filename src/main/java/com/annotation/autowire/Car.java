package com.annotation.autowire;

import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.autowire
 * @author:admin
 * @createTime 9月 19 2021 18:21:22
 */
@Component
public class Car {
    public Car() {
        System.out.println("--- car constructor without args ---");
    }
}
