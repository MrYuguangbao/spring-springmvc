package com.annotation.importanno;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.importanno
 * @author:admin
 * @createTime 9月 18 2021 23:45:14
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * @param annotationMetadata 当前类的注解信息
     * @param beanDefinitionRegistry 通过调用BeanDefinitionRegistry.registerBeanDefinition手工注册当前类到容器作为Bean
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean blue = beanDefinitionRegistry.containsBeanDefinition("com.annotation.importanno.Blue");
        boolean orange = beanDefinitionRegistry.containsBeanDefinition("com.annotation.importanno.Orange");
        if (blue && orange) {
            RootBeanDefinition mbd = new RootBeanDefinition(RainBow.class);
            beanDefinitionRegistry.registerBeanDefinition("rainBow", mbd);
        }
    }
}
