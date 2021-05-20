package com.springtest.mybatis_spring;

import org.mybatis.spring.mapper.ClassPathMapperScanner;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * @Author: admin
 * @Description: 自定义路径扫描器
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.mybatis_spring
 * @CreateTime: 2021-05-19 21:41:52
 */
public class ArtistScanner extends ClassPathBeanDefinitionScanner {

	public ArtistScanner(BeanDefinitionRegistry registry) {
		super(registry);
	}

	@Override
	protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
		return beanDefinition.getMetadata().isInterface();
	}

	@Override
	protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
		Set<BeanDefinitionHolder> holders = super.doScan(basePackages);
		// 需要把扫描到的mapper接口转换为beanClass设置为自定义FactoryBean
		for (BeanDefinitionHolder bdholder : holders) {
			GenericBeanDefinition bd = (GenericBeanDefinition) bdholder.getBeanDefinition();
			bd.getConstructorArgumentValues().addGenericArgumentValue(bd.getBeanClassName());
			bd.setBeanClass(ArtistFactoryBean.class);
		}
		return holders;
	}


}
