package com.annotation.autowire;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.autowire
 * @author:admin
 * @createTime 9月 19 2021 16:41:29
 */
@ComponentScan("com.annotation.autowire")
@Configuration
public class AutowiredConfig {

    @Bean("springDao2")
    public SpringDao springDao() {
        SpringDao springDao = new SpringDao();
        springDao.setLabel(2);
        return springDao;
    }

    @Bean("javaDao2")
    public JavaDao javaDao() {
        JavaDao javaDao = new JavaDao();
        javaDao.setLabel("2");
        return javaDao;
    }

    @Bean
    public Teacher teacher(Car car) {
        Teacher teacher = new Teacher();
        teacher.setCar(car);
        return teacher;
    }
}
