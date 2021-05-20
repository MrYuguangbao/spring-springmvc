package com.springtest.mybatis_spring;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: admin
 * @Description: 自定义FactoryBean
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.mybatis_spring
 * @CreateTime: 2021-05-19 21:12:16
 */
public class ArtistFactoryBean implements FactoryBean {

	private Class mapperInterface;
	private SqlSession sqlSession;

	public ArtistFactoryBean(Class mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		sqlSessionFactory.getConfiguration().addMapper(mapperInterface);
		this.sqlSession = sqlSessionFactory.openSession();
	}

	@Override
	public Object getObject() throws Exception {
		Object mapper = sqlSession.getMapper(mapperInterface);
		return mapper;

	}

	@Override
	public Class<?> getObjectType() {
		return mapperInterface;
	}
}
