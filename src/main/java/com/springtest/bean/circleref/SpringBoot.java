package com.springtest.bean.circleref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author: admin
 * @Description: 自定义类
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.bean.circleref
 * @CreateTime: 2021-05-19 09:10:44
 */
@Component
public class SpringBoot {

	private Long id;
	private String name;
	private LocalDateTime startTime;

	public SpringBoot() {
		System.out.println("SpringBoot的无参构造函数");
	}

	public SpringBoot(Long id, String name, LocalDateTime startTime) {
		this.id = id;
		this.name = name;
		this.startTime = startTime;
		System.out.println("SpringBoot的有参构造函数");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "SpringBoot{" +
				"id=" + id +
				", name='" + name + '\'' +
				", startTime=" + startTime +
				'}';
	}
}
