package com.springtest.loadproperties;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 18:19
 */
@Configuration
@ComponentScan(basePackages = {"com.springtest.t"})
//@PropertySource(value = {"classpath:jdbc.properties"}, ignoreResourceNotFound = true)
@ImportResource({"classpath:spring-profile-data.xml"})
public class ApplicationConfig1 {

    /*@Bean
    public PropertySourcesPlaceholderConfigurer getConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }*/

}
