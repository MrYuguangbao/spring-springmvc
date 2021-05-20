package com.springtest.model.loadproperty;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author admin
 * @date 2020/1/6 22:33
 */
@ComponentScan("com.springtest.model.loadproperty")
@ImportResource(value = {"classpath:META-INF/spring-data-backup3.xml"})
public class PropConfig {


}
