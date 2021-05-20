package com.springtest.aop.xml;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @date 2020/1/7 14:55
 */
@ComponentScan(basePackages = "com.springtest.aop.xml")
@ImportResource(value = "classpath:META-INF/spring-aop.xml")
//@EnableAspectJAutoProxy
public class XmlConfig {


}
