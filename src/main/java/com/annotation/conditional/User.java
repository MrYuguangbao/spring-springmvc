package com.annotation.conditional;

/**
 * @Author: admin
 * @Description: 测试类2
 * @BelongsProject: spring
 * @BelongsPackage: org.springframework.demo.lifecycle
 * @CreateTime: 2021-05-03 16:39:27
 */
public class User {

	private String name;
	private Integer age;

	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
