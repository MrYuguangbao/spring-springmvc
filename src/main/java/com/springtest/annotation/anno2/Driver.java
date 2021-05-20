package com.springtest.annotation.anno2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.SmartLifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: admin
 * @Description: 测试类
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.annotation.anno
 * @CreateTime: 2021-05-15 10:16:30
 */
public class Driver implements InitializingBean, DisposableBean, SmartLifecycle {

	private String name;
	private Integer age;

	public Driver() {
		System.out.println("---Driver的无参构造函数");
	}

	public void init() {
		System.out.println("driver的自定义初始化方法");
	}

	public void myDestroy() {
		System.out.println("driver的自定义销毁方法");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("driver的postConstruct");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("driver的preDestroy");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Driver{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("driver的afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("driver的destroy");
	}

	@Override
	public void start() {
		System.out.println("--start--");
	}

	@Override
	public void stop() {
		System.out.println("--stop--");
	}

	@Override
	public boolean isRunning() {
		return false;
	}
}
