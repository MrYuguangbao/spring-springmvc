package com.springtest.observer.example;

/**
 * @author admin
 * @date 2020/1/4 16:53
 */
public class ConcreteObserver2 implements IObserver {


    @Override
    public void update(Object message) {
        System.out.println("具体观察者2收到通知：" + (String) message);
    }
}
