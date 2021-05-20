package com.springtest.profile;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 17:12
 */
@ComponentScan(basePackages = {"com.springtest.profile"})
@ImportResource({"classpath:spring-profile-data.xml"})
public class MyJavaConfig {
}
