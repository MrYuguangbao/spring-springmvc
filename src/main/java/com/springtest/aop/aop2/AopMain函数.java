package com.springtest.aop.aop2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author admin
 * @date 2019/8/6 19:03
 */
public class AopMain函数 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AOPConfig.class);
        AOP接口 aop = ac.getBean(AOP接口.class);
        AOP验证器 aop验证器 = (AOP验证器) aop;

        User实体类 user实体类 = new User实体类();
        user实体类.setId(1);
        user实体类.setName("username");

        if (aop验证器.verify(user实体类)) {
            aop.print(user实体类, 10);
        } else {
            System.out.println("user对象为空！");
        }
//        aop.print(null);

        ((AnnotationConfigApplicationContext) ac).close();

    }

}
