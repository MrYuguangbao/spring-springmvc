package multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author admin
 * @desc
 * @date 2019/7/21 23:48
 */
public class MyService {
    private Lock lock = new ReentrantLock();

    public void testMethod() {
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println("线程名：" + Thread.currentThread().getName() + " " + (i + 1));
        }

        lock.unlock();
    }


}
