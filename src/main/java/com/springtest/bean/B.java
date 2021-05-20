package com.springtest.bean;

import lombok.Data;

/**
 * @author admin
 * @desc
 * @date 2019/7/17 22:16
 */
@Data
public class B {

    private C c;

    public B(C c) {
        this.c = c;
    }

    public void b() {
        c.c();
    }

}
