package com.annotation.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @version 1.0
 * @project: spring
 * @package: org.springframework.demo.conditional
 * @author:admin
 * @createTime 9月 18 2021 22:42:18
 */
public class ConditionalMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConditionalConfig.class);
		ConfigurableEnvironment environment = ac.getEnvironment();
		String os = environment.getProperty("os.name");
		System.out.println("os = " + os);
		String[] beanNamesForType = ac.getBeanNamesForType(User.class);
		for (String s : beanNamesForType) {
			System.out.println(s);
		}

		Map<String, User> map = ac.getBeansOfType(User.class);
		System.out.println(map);

	}

}
