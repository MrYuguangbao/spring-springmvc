package com.springtest.bean.circleref;

import org.springframework.stereotype.Component;

/**
 * @Author: admin
 * @Description: 测试类B
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.bean.circleref
 * @CreateTime: 2021-05-18 23:01:52
 */
@Component
public class B {

	private A a;

	public B() {
		System.out.println("B的无参构造函数");
	}

	public void setA(A a) {
		this.a = a;
	}

	public A getA() {
		return a;
	}
}
