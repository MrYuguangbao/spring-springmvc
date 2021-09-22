package com.annotation.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.lifecycle
 * @author:admin
 * @createTime 9月 19 2021 08:39:09
 */
public class Car implements InitializingBean, DisposableBean {

    @Value("blue")
    private String color;

    @Value("${car2.nickname}")
    private String name;

    @Value("#{20-2}")
    private int age;

    public Car() {
        System.out.println("---- car constructor without args ----");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void atBeaninit() {
        System.out.println("自定义init方法");
    }

    public void atBeandestroy() {
        System.out.println("自定义destroy方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("实现InitializingBean的afterPropertiesSet方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("实现DisposableBean的destroy方法");
    }

    @PostConstruct
    public void myPostConstruct() {
        System.out.println("注解@PostConstruct标注的myPostConstruct方法");
    }

    @PreDestroy
    public void myPredestroy() {
        System.out.println("注解@PreDestroy标注的myPredestroy方法");
    }


}
