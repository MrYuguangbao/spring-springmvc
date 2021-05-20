package com.springtest;

/**
 * @author admin
 * @desc
 * @date 2019/7/21 8:46
 */
public class VolatileThread implements Runnable {

    private volatile int a = 0;
    private String name;

    public VolatileThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (this) {
            ++a;
            System.out.println(Thread.currentThread().getName() + "---------->" + a);
            try {
                Thread.sleep(1000);
                a += 2;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "---------->" + a);
        }
    }

}
