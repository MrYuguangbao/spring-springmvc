package com.springtest.observer.observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author admin
 * @date 2020/1/4 16:31
 */
public class ProductObservable extends Observable {

    private List<String> list = null;
    private static ProductObservable instance;

    private ProductObservable() {
    }

    public static ProductObservable getInstance() {
        if (instance == null) {
            instance = new ProductObservable();
            instance.list = new ArrayList<>();
        }
        return instance;
    }

    /**
     * 增加观察者
     *
     * @param observer
     */
    public void addProductObserver(Observer observer) {
        this.addObserver(observer);
    }

    public void addProduct(String product) {
        list.add(product);
        System.out.println("新增产品：" + product);
        //设置被观察对象发生变化
        this.setChanged();
        //通知观察者，并传递新产品
        this.notifyObservers(product);
    }


}
