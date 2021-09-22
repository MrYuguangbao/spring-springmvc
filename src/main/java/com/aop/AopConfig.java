package com.aop;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.aop
 * @author:admin
 * @createTime 9月 20 2021 18:00:15
 */
//@ComponentScan("com.aop")
@EnableAspectJAutoProxy
@Configuration
public class AopConfig {

    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }


}
