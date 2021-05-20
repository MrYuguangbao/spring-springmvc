package com.springtest.aop.aop3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: admin
 * @Description: 主函数
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.aop.aop3
 * @CreateTime: 2021-05-09 10:14:19
 */
public class AspectMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AspectConfig.class);
		Calculate bean = ac.getBean(Calculate.class);
		int res = bean.div(7, 2);
		System.out.println("执行结果：" + res);


	}



}
