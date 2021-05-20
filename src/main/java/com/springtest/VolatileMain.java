package com.springtest;

/**
 * @author admin
 * @desc
 * @date 2019/7/21 8:55
 */
public class VolatileMain {
    public static void main(String[] args) {
        VolatileThread thread1 = new VolatileThread("线程1");
        VolatileThread thread2 = new VolatileThread("线程2");
        VolatileThread thread3 = new VolatileThread("线程3");
        VolatileThread thread4 = new VolatileThread("线程4");
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread1);
        Thread t3 = new Thread(thread1);
        Thread t4 = new Thread(thread1);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
