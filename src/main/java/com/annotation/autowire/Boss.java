package com.annotation.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.autowire
 * @author:admin
 * @createTime 9月 19 2021 18:21:10
 */
@Component
public class Boss {

    private Car car;


    public Boss(Car car) {
        this.car = car;
        System.out.println("--- Boss的有参构造函数 ---");
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
