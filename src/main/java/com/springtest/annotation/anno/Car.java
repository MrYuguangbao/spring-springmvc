package com.springtest.annotation.anno;

import com.springtest.annotation.qualifier.Person;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: admin
 * @Description: 生命周期注解
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.annotation
 * @CreateTime: 2021-05-08 16:27:08
 */
@Component
public class Car implements InitializingBean, DisposableBean {

	@Value("spring")
	private String name;
	@Value("#{20-3}")
	private Integer age;
	@Value("${database.username}")
	private String addr;

	@Override
	public String toString() {
		return "Car{" +
				"name='" + name + '\'' +
				", age=" + age +
				", addr='" + addr + '\'' +
				'}';
	}

	public Car() {
		System.out.println("4.--无参构造函数");
	}


	@Override
	public void destroy() throws Exception {
		System.out.println("---destroy方法");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("6.--afterPropertiesSet方法");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("5.--postConstruct注解");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("--preDestroy");
	}
}
