package com.springtest.observer;

/**
 * @author admin
 * @desc
 * @date 2019/7/23 15:14
 */
public class MainTest {
    public static void main(String[] args) {
        Notifier notifier = new Notifier();
        Observer1 o1 = new Observer1();
        Observer2 o2 = new Observer2();
        Observer3 o3 = new Observer3();
        notifier.addMyObserver(o1);
        notifier.addMyObserver(o2);
        notifier.addMyObserver(o3);
        notifier.notifyMsg("新增产品");


    }

}
