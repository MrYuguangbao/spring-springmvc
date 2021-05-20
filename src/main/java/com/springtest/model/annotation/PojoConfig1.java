package com.springtest.model.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author admin
 * @date 2020/1/6 16:59
 */
//@ComponentScan(basePackages = "com.springtest.model")
@ImportResource(value = {"classpath:META-INF/spring-data-backup.xml"})
public class PojoConfig1 {


}
