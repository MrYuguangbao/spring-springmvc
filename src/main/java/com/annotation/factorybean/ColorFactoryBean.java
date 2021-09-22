package com.annotation.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.factorybean
 * @author:admin
 * @createTime 9月 19 2021 08:06:25
 */
public class ColorFactoryBean implements FactoryBean<Color> {


    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean#getObject");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        //return FactoryBean.super.isSingleton();
        return true;
    }
}
