package com.springtest.observer.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @date 2020/1/4 16:52
 */
@Data
public class ConcreteNotify2 implements INotifier {

    private List<IObserver> list = new ArrayList<>();
    private String message;

    @Override
    public void addObserver(IObserver observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        list.remove(observer);
    }

    @Override
    public void sendNotify() {
        for (IObserver iObserver : list) {
            iObserver.update(message);
        }
    }
}
