package com.annotation.autowire;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.autowire
 * @author:admin
 * @createTime 9月 20 2021 11:45:08
 */
@Component
public class MyAware implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("当前beanName:" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ac容器：" + applicationContext);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        String s = stringValueResolver.resolveStringValue("你好：${os.name}, #{10 * 20}");
        System.out.println("s:" + s);
    }
}
