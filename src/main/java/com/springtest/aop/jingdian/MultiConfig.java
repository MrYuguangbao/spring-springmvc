package com.springtest.aop.jingdian;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author admin
 * @date 2020/1/7 16:34
 */
@ComponentScan("com.springtest.aop.jingdian")
@EnableAspectJAutoProxy
@Configuration
public class MultiConfig {

    @Bean
    public Aspect1 getAspect1() {
        return new Aspect1();
    }

    @Bean
    public Aspect2 getAspect2() {
        return new Aspect2();
    }

    @Bean
    public Aspect3 getAspect3() {
        return new Aspect3();
    }
}
