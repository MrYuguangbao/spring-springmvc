package com.springtest.bean;

import lombok.Data;

/**
 * @author admin
 * @desc
 * @date 2019/7/17 22:16
 */
@Data
public class C {
    private A a;

    public C(A a) {
        this.a = a;
    }

    public void c() {
        a.a();
    }
}
