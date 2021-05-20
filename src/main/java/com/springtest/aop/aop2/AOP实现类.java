package com.springtest.aop.aop2;

import org.springframework.stereotype.Component;

/**
 * @author admin
 * @date 2019/8/6 18:47
 */
@Component
public class AOP实现类 implements AOP接口 {
    @Override
    public void print(User实体类 user, int sort) {//作为aop的连接点
        System.out.println("调用连接点方法：" + user.getId() + "," + user.getName() + ",参数：" + sort);
    }
}
