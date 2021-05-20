package com.springtest.observer.example;

public interface INotifier {
    void addObserver(IObserver observer);

    void removeObserver(IObserver observer);

    void sendNotify();
}
