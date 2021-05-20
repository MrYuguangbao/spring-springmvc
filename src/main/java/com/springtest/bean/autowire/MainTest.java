package com.springtest.bean.autowire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: admin
 * @Description: 主函数测试
 * @BelongsProject: spring
 * @BelongsPackage: org.springframework.demo.autowire
 * @CreateTime: 2021-05-02 21:30:08
 */
public class MainTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MyService myService = ac.getBean("myService", MyService.class);
		System.out.println(myService);

	}


}
