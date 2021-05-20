package com.springtest.annotation.anno;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: admin
 * @Description: 自定义BeanFactoryPostProcessor
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.annotation.anno
 * @CreateTime: 2021-05-10 14:00:06
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("3.----自定义BeanFactoryPostProcessor");
	}

}
