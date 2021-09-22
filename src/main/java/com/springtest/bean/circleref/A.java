package com.springtest.bean.circleref;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Author: admin
 * @Description: 測試类A
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.bean.circleref
 * @CreateTime: 2021-05-18 23:01:30
 */
@Component
public class A {

	private B b;

	public A() {
		System.out.println("A的无参构造函数");
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}

	public void hello() {
		System.out.println("调用A的hello()方法");
	}
}
