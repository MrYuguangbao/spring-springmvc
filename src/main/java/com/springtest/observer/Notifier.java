package com.springtest.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author admin
 * @desc
 * @date 2019/7/23 15:09
 */
public class Notifier extends Observable {

    private List<String> productList = null;

    public Notifier() {
        productList = new ArrayList<String>();
    }

    /*private Notifier(){}

    private static Notifier instance;
    public static Notifier getInstance(){
        if (instance == null) {
            instance = new Notifier();
            instance.productList = new ArrayList<String>();
        }
        return instance;
    }*/

    public void addMyObserver(Observer observer) {
        this.addObserver(observer);
    }

    public void notifyMsg(String message) {
        productList.add(message);
        System.out.println("通知者发送消息：" + message);
        this.setChanged();//设置通知者发生变化
        this.notifyObservers(message);//通知观察者
    }

}
