package com.springtest.model.autowire;

import javafx.application.Application;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author admin
 * @date 2020/1/6 20:16
 */
@Component
public class ExternalBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    @Bean(name = "prop"/*, initMethod = "init", destroyMethod = "destory"*/)
    public Properties getProperties() {
        Properties props = new Properties();
        props.put("driver", "com.mysql");
        props.put("url", "myurl");
        return props;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(this.getClass().getName() + "2");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("1");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getName() + "6");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getName() + "4");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(this.getClass().getName() + "3");
    }

    public void init() {
        System.out.println(this.getClass().getName() + "5");
    }

    public void destory() {
        System.out.println(this.getClass().getName() + "7");
    }
}
