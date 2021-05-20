package com.springtest.mybatis_spring;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: admin
 * @Description: spring整合mybatis自定义扫描注解
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.mybatis_spring
 * @CreateTime: 2021-05-05 21:15:19
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(ArtistImportBeanDefinitionRegistrar.class)
public @interface ArtistSacn {
	String value();
}
