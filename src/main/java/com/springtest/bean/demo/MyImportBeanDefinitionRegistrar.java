package com.springtest.bean.demo;

import com.springtest.bean.demo.condition.Rainbow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: admin
 * @Description: 自定义ImportBeanDefinitionRegistrar
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.bean.demo
 * @CreateTime: 2021-05-16 11:53:34
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean yellow = registry.containsBeanDefinition("com.springtest.bean.demo.condition.Yellow");
		boolean red = registry.containsBeanDefinition("com.springtest.bean.demo.condition.Red");
		if (yellow && red) {
			RootBeanDefinition bd = new RootBeanDefinition(Rainbow.class);
			registry.registerBeanDefinition("rainbow", bd);
		}
	}
}
