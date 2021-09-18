package com.annotation;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation
 * @author:admin
 * @createTime 9月 18 2021 21:11:46
 */
public class Child extends Parent {

    public static void main(String[] args) {
        Class<Child> clazz = Child.class;
        MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.name());

    }
}
