package com.springtest.aop.aop2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author admin
 * @date 2019/8/6 19:00
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.springtest.aop.aop2")
public class AOPConfig {

    @Bean
    public User切面 getUser切面() {
        return new User切面();
    }

    //@Bean
    public User切面_Pointcut注解 getUser切面_Pointcut注解() {
        return new User切面_Pointcut注解();
    }

}
