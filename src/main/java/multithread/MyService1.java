package multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author admin
 * @desc
 * @date 2019/7/21 23:53
 */
public class MyService1 {
    private Lock lock = new ReentrantLock();

    public void method1() {
        try {
            lock.lock();
            System.out.println("method1 开始,ThreadName=" + Thread.currentThread().getName() + ",time=" + System.currentTimeMillis());
            Thread.sleep(2);
            System.out.println("method1 结束,ThreadName=" + Thread.currentThread().getName() + ",time=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void method2() {
        try {
            lock.lock();
            System.out.println("method2 开始,ThreadName=" + Thread.currentThread().getName() + ",time=" + System.currentTimeMillis());
            Thread.sleep(2);
            System.out.println("method2 结束,ThreadName=" + Thread.currentThread().getName() + ",time=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
