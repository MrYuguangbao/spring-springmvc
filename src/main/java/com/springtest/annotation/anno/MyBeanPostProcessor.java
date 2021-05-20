package com.springtest.annotation.anno;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: admin
 * @Description: 自定义后置处理器
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.annotation
 * @CreateTime: 2021-05-08 17:13:30
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("--自定义BeanPostProcessor的BeforeInitialization," + beanName+"--->"+bean);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("--自定义BeanPostProcessor的AfterInitialization," + beanName+"--->"+bean);
		return bean;
	}
}
