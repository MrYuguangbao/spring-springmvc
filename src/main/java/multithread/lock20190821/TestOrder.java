package multithread.lock20190821;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author admin
 * @date 2019/8/21 18:40
 */
public class TestOrder {

    private volatile static int next = 1;
    private static Lock lock = new ReentrantLock();
    public static Condition condition1 = lock.newCondition();
    public static Condition condition2 = lock.newCondition();
    public static Condition condition3 = lock.newCondition();

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (next != 1) {
                        condition1.await();
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println("t1:" + (i + 1));
                    }
                    next = 2;
                    condition2.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (next != 2) {
                        condition2.await();
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println("t2:" + (i + 1));
                    }
                    next = 3;
                    condition3.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (next != 3) {
                        condition3.await();
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println("t3:" + (i + 1));
                    }
                    next = 1;
                    condition1.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };
        Thread[] threads1 = new Thread[3];
        Thread[] threads2 = new Thread[3];
        Thread[] threads3 = new Thread[3];
        for (int i = 0; i < 1; i++) {
            threads1[i] = new Thread(t1);
            threads2[i] = new Thread(t2);
            threads3[i] = new Thread(t3);
            threads1[i].start();
            threads2[i].start();
            threads3[i].start();

        }


    }

}
