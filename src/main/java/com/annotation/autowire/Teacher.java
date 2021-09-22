package com.annotation.autowire;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.autowire
 * @author:admin
 * @createTime 9月 20 2021 11:20:55
 */
public class Teacher {
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "car=" + car +
                '}';
    }
}
