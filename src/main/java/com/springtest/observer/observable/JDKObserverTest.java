package com.springtest.observer.observable;

/**
 * @author admin
 * @date 2020/1/4 16:39
 */
public class JDKObserverTest {

    public static void main(String[] args) {
        ProductObservable observable = ProductObservable.getInstance();
        observable.addObserver(new JDObserver());
        observable.addObserver(new TBObserver());

        System.out.println("被观察者新增产品");
        observable.addProduct("iPhone 11 Pro Max");

    }


}
