package com.springtest.bean.lifecycle;

import sun.management.Agent;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: admin
 * @Description: 测试反射
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.bean.lifecycle
 * @CreateTime: 2021-05-03 16:14:07
 */
public class User {

	private String name;
	protected Integer age;
	public String address;

	public User() {
		System.out.println("无参构造函数");
	}

	public User(String name) {
		System.out.println("一个参数的构造函数");
	}

	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public void show() {
		System.out.println("show方法");
	}

	public static void main(String[] args) {
		User user = new User();
		Class<? extends User> clazz = user.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}

	}
}
