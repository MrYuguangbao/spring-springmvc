package com.springtest.bean;

import lombok.Data;

/**
 * @author admin
 * @desc
 * @date 2019/7/17 18:11
 */
@Data
public class HelloWord {
    private String name;

    public void show() {
        System.out.println("hello," + name);
    }

    public void say() {
        System.out.println("hello spring!");
    }
}
