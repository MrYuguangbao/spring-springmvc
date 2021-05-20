package multithread.reentrantreadwriteLock;

import util.MyDateTimeUtils;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 18:10
 */
public class ReadReadTest {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            lock.readLock().lock();
            System.out.println("获取读锁：" + Thread.currentThread().getName() + ",时间：" + MyDateTimeUtils.format(LocalDateTime.now()));
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadReadTest test = new ReadReadTest();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.read();
                }
            }).start();
        }
    }
}
