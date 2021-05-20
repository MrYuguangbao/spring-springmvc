package com.springtest.aop.aop3;

/**
 * @Author: admin
 * @Description: 业务逻辑类
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.aop.aop3
 * @CreateTime: 2021-05-09 10:11:13
 */
public class Calculate {

	public int div(int a, int b) {
		System.out.println("<业务逻辑div方法>");
		return a / b;
	}

}
