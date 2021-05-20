package com.springtest.bean.demo;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @Author: admin
 * @Description: 主函数
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.bean.demo
 * @CreateTime: 2021-05-16 09:59:15
 */
public class ImportMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AnnConfig.class);

		System.out.println("------编程方式注入一个bean到Spring容器");
		AbstractBeanDefinition bd = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		bd.setBeanClass(Orange.class);
		ac.registerBeanDefinition("orangeBean", bd);

		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String b : beanDefinitionNames) {
			System.out.println(b);
		}

		Object res1 = ac.getBean("myFactoryBean");
		Object res2 = ac.getBean("&myFactoryBean");
		System.out.println("res1:" + res1.getClass());
		System.out.println("res2:" + res2.getClass());
	}

}
