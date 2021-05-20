package com.springtest.aop;

import lombok.Data;

/**
 * @author admin
 * @desc
 * @date 2019/7/17 23:10
 */
@Data
public class TestBean {
    private String str = "aopStr";

    public void test() {
        System.out.println("--- test ---");
    }
}
