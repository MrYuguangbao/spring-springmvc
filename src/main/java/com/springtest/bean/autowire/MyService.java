package com.springtest.bean.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: admin
 * @Description: 测试类1
 * @BelongsProject: spring
 * @BelongsPackage: org.springframework.demo.autowire
 * @CreateTime: 2021-05-02 21:28:17
 */
@Component
public class MyService {

	@Autowired
	private OrderService orderService;

}
