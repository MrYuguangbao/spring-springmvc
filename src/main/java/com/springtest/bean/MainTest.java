package com.springtest.bean;

import com.springtest.mybatis.model.PojoConfig;
import com.springtest.mybatis.model.User;
import javafx.application.Application;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.io.InputStream;


/**
 * @author admin
 * @desc
 * @date 2019/7/17 18:12
 */
public class MainTest {

    public static void main(String[] args) {
        /*System.out.println("---------- 开始加载xml配置文件 ---------- ");
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        HelloWord helloWord = (HelloWord)context.getBean("helloWorld");
        System.out.println("---------- 获取bean结束 ---------- ");
        helloWord.show();*/

        /*ApplicationContext context = new AnnotationConfigApplicationContext(PojoConfig.class);
        User user = (User) context.getBean("user");
        System.out.println(user.getId());*/

        /*String s = BeanFactoryUtils.transformedBeanName("&&^qwer");
        System.out.println(s);*/

    }
}
