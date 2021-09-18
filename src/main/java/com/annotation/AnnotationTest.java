package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.springtest.annotation
 * @desc: 注解测试
 * @author:admin
 * @createTime 9月 18 2021 20:39:32
 */
@MyAnnotation(name = "nametest")
public class AnnotationTest {

    @MyAnnotation(name = "name of method")
    public String hello() {
        return "hello";
    }

    public static void main(String[] args) {
        Class<AnnotationTest> clazz = AnnotationTest.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType().getName());
        }

        try {
            Method method = clazz.getMethod("hello", new Class[]{});
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                System.out.println(annotation.name());
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    /*@SourcePolicy
    public void testSource() {

    }

    @ClassPolicy
    public void testClass() {

    }

    @RuntimePolicy
    public void testRuntime() {

    }*/



}
