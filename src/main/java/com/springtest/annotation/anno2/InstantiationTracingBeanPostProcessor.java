package com.springtest.annotation.anno2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: admin
 * @Description: 自定义后置处理器
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.annotation.anno2
 * @CreateTime: 2021-05-15 11:33:49
 */
@Component
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean '" + beanName + "' created : " + bean.toString());
		return bean;
	}
}
