package com.springtest.bean.demo;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @Author: admin
 * @Description: 自定义FactoryBean
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.bean.demo
 * @CreateTime: 2021-05-16 17:34:28
 */
public class MyFactoryBean implements FactoryBean<Purle> {

	@Override
	public Purle getObject() throws Exception {
		return new Purle();
	}

	@Override
	public Class<?> getObjectType() {
		return Purle.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
