package com.springtest.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @desc
 * @date 2019/7/25 23:40
 */
//@Component
public class BeanProcessorImpl implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("4.【" + this.getClass().getSimpleName() + "】对象" + beanName + "开始实例化,调用BeanPostProcessor的postProcessBeforeInitialization方法");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("7.【" + this.getClass().getSimpleName() + "】对象" + beanName + "实例化完成,调用BeanPostProcessor的postProcessAfterInitialization方法");
        return bean;
    }
}
