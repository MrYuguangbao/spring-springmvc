package com.springtest.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: admin
 * @Description: 自定义bean后置处理器
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.bean.lifecycle
 * @CreateTime: 2021-05-03 10:59:41
 */
@Component
public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("---实例化之前");
		return null;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		System.out.println("----实例化之后");
		return false;
	}
}
