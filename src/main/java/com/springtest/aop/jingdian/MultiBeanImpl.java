package com.springtest.aop.jingdian;

import org.springframework.stereotype.Component;

/**
 * @author admin
 * @date 2020/1/7 16:30
 */
@Component
public class MultiBeanImpl implements MultiBean {

    @Override
    public void testMultiBean() {
        System.out.println("测试testMultiBean");
    }
}
