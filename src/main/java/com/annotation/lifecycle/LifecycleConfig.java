package com.annotation.lifecycle;

import org.springframework.context.annotation.*;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.lifecycle
 * @author:admin
 * @createTime 9月 19 2021 08:38:45
 */
@ComponentScan("com.annotation.lifecycle")
@Configuration
@PropertySources(value = {
        @PropertySource(value = {"classpath:/car.properties"}),
        @PropertySource(value = {"classpath:/car2.properties"})
})
public class LifecycleConfig {

    @Bean(initMethod = "atBeaninit", destroyMethod = "atBeandestroy")
    public Car car() {
        return new Car();
    }


}
