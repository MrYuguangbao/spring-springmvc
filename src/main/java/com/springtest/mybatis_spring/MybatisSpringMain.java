package com.springtest.mybatis_spring;

import com.springtest.mybatis_spring.mapper.UserMapper;
import com.springtest.mybatis_spring.service.UserService;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@ArtistSacn("com.springtest.mybatis_spring")
public class MybatisSpringMain {

    public static void main(String[] args) {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/applicationContext.xml");
        UserMapper bean = context.getBean(UserMapper.class);
        User user = bean.queryUserById(6);
        System.out.println(user.getId() + "," + user.getName());*/
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MybatisSpringConfig.class);

        UserService userService = (UserService) ac.getBean("userService");
        userService.func();
    }

}
