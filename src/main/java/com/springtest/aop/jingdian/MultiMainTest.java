package com.springtest.aop.jingdian;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author admin
 * @date 2020/1/7 16:37
 */
public class MultiMainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MultiConfig.class);
        MultiBean bean = context.getBean(MultiBean.class);

        bean.testMultiBean();
        context.close();

    }


}
