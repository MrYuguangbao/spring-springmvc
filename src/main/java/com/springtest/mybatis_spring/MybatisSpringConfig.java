package com.springtest.mybatis_spring;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: admin
 * @Description: mybatis整合spring配置类
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.mybatis_spring
 * @CreateTime: 2021-05-05 21:21:31
 */
@ComponentScan("com.springtest.mybatis_spring")
@ArtistSacn("com.springtest.mybatis_spring.mapper")
public class MybatisSpringConfig {

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("META-INF/mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}

}
