package com.springtest.mybatis_spring.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @Author: admin
 * @Description: 用户mapper
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.mybatis_spring.mapper
 * @CreateTime: 2021-05-19 21:00:51
 */
public interface OrderMapper {

	@Select("select 'order'")
	String selectByOrderId();
}
