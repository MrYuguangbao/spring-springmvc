package com.springtest.aop.aop3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: admin
 * @Description: 配置类
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.aop.aop3
 * @CreateTime: 2021-05-09 10:11:36
 */
@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {

	@Bean
	public Calculate calculate() {
		return new Calculate();
	}

	@Bean
	public MyAspect myAspect() {
		return new MyAspect();
	}
}
