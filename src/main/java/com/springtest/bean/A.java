package com.springtest.bean;

import lombok.Data;

/**
 * @author admin
 * @desc
 * @date 2019/7/17 22:16
 */
@Data
public class A {
    private B b;

    public A(B b) {
        this.b = b;
    }

    public void a() {
        b.b();
    }


}
