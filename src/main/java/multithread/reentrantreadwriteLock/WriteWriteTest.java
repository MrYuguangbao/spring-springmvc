package multithread.reentrantreadwriteLock;

import util.MyDateTimeUtils;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 18:15
 */
public class WriteWriteTest {
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void read() {
        try {
            readWriteLock.readLock().lock();
            System.out.println("获取读锁：" + Thread.currentThread().getName() + ",时间：" + MyDateTimeUtils.format(LocalDateTime.now()));
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void write() {
        Lock writeLock = readWriteLock.writeLock();
        writeLock.lock();
        System.out.println("获得写锁:" + Thread.currentThread().getName() + ",当前时间：" + MyDateTimeUtils.format(LocalDateTime.now()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        WriteWriteTest test = new WriteWriteTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.write();
            }
        }, "线程1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.read();
            }
        }, "线程2").start();
    }

}
