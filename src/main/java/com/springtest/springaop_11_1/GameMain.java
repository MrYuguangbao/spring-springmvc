package com.springtest.springaop_11_1;

import com.springtest.profile.People;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 22:54
 */
public class GameMain {
    public static void main(String[] args) {
        IPeople iPeople = new PeopeoImpl();

        Interceptor interceptor = new PeopleInterceptor();
        IPeople iPeople1 = (IPeople) ProxyBeanFactory.getBean(iPeople, interceptor);

        People people = new People();
        people.setId(7);
        people.setName("iiiiii");
        people.setIdentifyId("666666");

        //iPeople1.printInfo(people);

        System.out.println("--------------- 测试异常情况 ----------------");
        people = null;
        iPeople1.printInfo(people);

    }
}
