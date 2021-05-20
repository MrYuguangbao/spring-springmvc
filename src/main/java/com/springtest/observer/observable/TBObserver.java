package com.springtest.observer.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * @author admin
 * @date 2020/1/4 16:39
 */
public class TBObserver implements Observer {

    @Override
    public void update(Observable o, Object product) {
        String arg = (String) product;
        System.out.println("发布新产品" + arg + "到淘宝");
    }
}
