package com.springtest.aop.aop2;

import org.springframework.stereotype.Component;

/**
 * @author admin
 * @date 2019/8/6 19:38
 */
@Component
public class AOP验证器实现类 implements AOP验证器 {
    @Override
    public boolean verify(User实体类 user) {
        System.out.println("调用了验证器");
        return user != null;
    }
}
