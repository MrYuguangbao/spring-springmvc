package com.springtest.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author admin
 * @desc
 * @date 2019/7/25 23:33
 */
@Component
public class Juice implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    public Juice() {
        System.out.println("juice的构造函数");
    }

    @PostConstruct
    public void postConstr() {
        System.out.println("----postConstruct注解的方法");
    }

    public void show() {
        System.out.println("------ 调用自己的逻辑方法：hello Juice！");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("1.【" + this.getClass().getSimpleName() + "】调用BeanNameAware的setBeanName方法，参数是："+name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("2.【" + this.getClass().getSimpleName() + "】调用BeanFactoryAware的setBeanFactory方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("3.【" + this.getClass().getSimpleName() + "】调用ApplicationContextAware的setApplicationContext方法" +
                ",[applicationContext ID]:"+applicationContext.getId()+
                ",[applicationContext name]:"+applicationContext.getApplicationName()+
                ",[applicationContext displayName]:"+applicationContext.getDisplayName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("5.【" + this.getClass().getSimpleName() + "】调用InitializingBean的afterPropertiesSet方法");
    }

    public void init() {
        System.out.println("6.【" + this.getClass().getSimpleName() + "】自定义初始化方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("8.【" + this.getClass().getSimpleName() + "】调用DisposableBean的destroy方法");
    }

    public void myDestroy() {
        System.out.println("9.【" + this.getClass().getSimpleName() + "】自定义销毁方法");
    }
}
