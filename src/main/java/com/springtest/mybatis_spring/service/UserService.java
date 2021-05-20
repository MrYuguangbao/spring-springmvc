package com.springtest.mybatis_spring.service;

import com.springtest.mybatis_spring.mapper.OrderMapper;
import com.springtest.mybatis_spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: admin
 * @Description: service
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.mybatis_spring.service
 * @CreateTime: 2021-05-19 21:02:48
 */
@Component
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private OrderMapper orderMapper;

	public void func() {
		System.out.println("执行结果是：" + userMapper.selectByUserId());
		System.out.println("执行结果是：" + orderMapper.selectByOrderId());
	}

}
