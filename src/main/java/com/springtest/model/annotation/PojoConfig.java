package com.springtest.model.annotation;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author admin
 * @date 2020/1/6 16:59
 */
//@ComponentScan(basePackages = "com.springtest.model")
@PropertySource(value = {"classpath:jdbc.properties"})
@Import({PojoConfig1.class, PojoConfig2.class})
public class PojoConfig {

    /*@Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }*/

}
