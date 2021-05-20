package multithread.lock20190821;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock实现同步
 *
 * @author admin
 * @date 2019/8/21 17:14
 */
public class ReentrantLock1 implements Runnable {

    private Lock lock = new ReentrantLock();


    @Override
    public void run() {
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println("thread:" + Thread.currentThread().getName() + ",i=" + i);

        }

        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLock1 r1 = new ReentrantLock1();
        ReentrantLock1 r2 = new ReentrantLock1();
        ReentrantLock1 r3 = new ReentrantLock1();
        new Thread(r1).start();
        new Thread(r2).start();
        new Thread(r3).start();

    }

}
