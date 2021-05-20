package multithread.lock20190821;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author admin
 * @date 2019/8/21 22:08
 */
public class ReadWriteLock1 {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        lock.writeLock().lock();
        try {
            System.out.println("获取写锁");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLock1 lock1 = new ReadWriteLock1();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                lock1.read();
            }
        };
        t1.start();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                lock1.read();
            }
        };
        t2.start();

    }
}
