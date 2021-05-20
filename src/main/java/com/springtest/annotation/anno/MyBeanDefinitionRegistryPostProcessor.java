package com.springtest.annotation.anno;

import com.springtest.annotation.qualifier.Person;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: admin
 * @Description: 自定义BeanDefinitionRegistryPostProcessor
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.annotation.anno
 * @CreateTime: 2021-05-10 14:37:54
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {


	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("1.---MyBeanDefinitionRegistryPostProcessor的postProcessBeanDefinitionRegistry方法,bean的数量是："+registry.getBeanDefinitionCount());
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Person.class).getBeanDefinition();
		registry.registerBeanDefinition("person", beanDefinition);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("2.---MyBeanDefinitionRegistryPostProcessor的postProcessBeanFactory方法，bean的数量是："+beanFactory.getBeanDefinitionCount());
	}
}
