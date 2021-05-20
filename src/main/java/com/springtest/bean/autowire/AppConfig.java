package com.springtest.bean.autowire;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Author: admin
 * @Description: 配置类
 * @BelongsProject: spring
 * @BelongsPackage: org.springframework.demo.autowire
 * @CreateTime: 2021-05-02 21:29:09
 */
@ComponentScan(value = "com.springtest.bean.autowire")
public class AppConfig {

	@Bean
	@Primary
	public MyService myService1() {
		return new MyService();
	}

	@Bean
	public MyService myService2() {
		return new MyService();
	}
}
