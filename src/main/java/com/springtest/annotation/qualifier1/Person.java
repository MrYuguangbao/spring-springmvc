package com.springtest.annotation.qualifier1;

import org.springframework.stereotype.Component;

/**
 * @author admin
 * @date 2020/4/2 21:50
 */
@Component
public class Person {

    public void say(){
        System.out.println("call person1");
    }

}
