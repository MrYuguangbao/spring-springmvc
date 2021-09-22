package com.springtest.bean.circleref;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDateTime;

/**
 * @Author: admin
 * @Description: 循环依赖主函数
 * @BelongsProject: spring
 * @BelongsPackage: org.springframework.demo.circularref
 * @CreateTime: 2021-05-06 17:35:39
 */
public class CircularRefMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(CircularRefConfig.class);
		A a = ac.getBean("a", A.class);
		a.hello();


	}


}
