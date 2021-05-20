package com.springtest.bean.assembly;

import com.springtest.mybatis.model.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 10:54
 */
//@ComponentScan(basePackageClasses = {User.class,UserServiceImpl.class})
@ComponentScan(basePackages = {"com.springtest.bean.assembly", "com.springtest.mybatis.model", "com.springtest.bean.lifecycle"})
@ImportResource({"classpath:/META-INF/spring-data.xml"})
public class ApplicationConfig {
}
