package com.springtest.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author admin
 * @desc
 * @date 2019/7/23 15:10
 */
public class Observer1 implements Observer {
    @Override
    public void update(Observable o, Object product) {
        System.out.println("同步新产品" + (String) product + "到通知者1");
    }
}
