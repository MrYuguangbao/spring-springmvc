package com.springtest.observer.example;

/**
 * @author admin
 * @date 2020/1/4 16:54
 */
public class ObserverMainTest1 {

    public static void main(String[] args) {
        INotifier notifier = new ConcreteNotify1();

        IObserver observer1 = new ConcreteObserver1();
        IObserver observer2 = new ConcreteObserver2();

        notifier.addObserver(observer1);
        notifier.addObserver(observer2);

        ((ConcreteNotify1) notifier).setMessage("MongoDB开始升级");
        notifier.sendNotify();


    }
}
