package com.springtest.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author admin
 * @desc
 * @date 2019/7/17 22:49
 */
public class TestAware implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void testAware() {
        HelloWord helloWord = (HelloWord) beanFactory.getBean("helloWorld");
        helloWord.say();
    }


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        TestAware testAware = (TestAware) context.getBean("testAware");
        testAware.testAware();

    }
}
