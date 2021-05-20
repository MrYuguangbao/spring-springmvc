package com.springtest.observer.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * @author admin
 * @date 2020/1/4 16:37
 */
public class JDObserver implements Observer {

    @Override
    public void update(Observable observable, Object product) {
        String arg = (String) product;
        System.out.println("发布新产品" + arg + "到京东");
    }
}
