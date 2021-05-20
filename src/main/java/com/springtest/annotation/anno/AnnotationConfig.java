package com.springtest.annotation.anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: admin
 * @Description: 注解配置类
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.annotation
 * @CreateTime: 2021-05-08 15:03:08
 */
@Configuration
@ComponentScan(value = "com.springtest.annotation.anno")
@PropertySource(value = {"classpath:/jdbc.properties"})
public class AnnotationConfig {

}
