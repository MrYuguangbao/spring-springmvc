package com.springtest.aop.aop2;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author admin
 * @date 2020/1/7 11:43
 */
@Component
public class AOP连接点2 {

    public void print(User实体类 user, int sort) {
        System.out.println("当前时间:" + LocalDateTime.now());
        System.out.println("调用连接点2方法：" + user.getId() + "," + user.getName() + ",排序参数:" + sort);
    }

}
