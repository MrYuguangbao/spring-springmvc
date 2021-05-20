package com.springtest.annotation.qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author admin
 * @date 2020/4/2 22:26
 */
@Configuration
public class AppConfig {

    @Bean
    public Person person(){
        return new Person();
    }

}
