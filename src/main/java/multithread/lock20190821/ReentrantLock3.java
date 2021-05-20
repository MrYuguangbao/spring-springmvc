package multithread.lock20190821;

import util.MyDateTimeUtils;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Condition实现等待/通知
 *
 * @author admin
 * @date 2019/8/21 17:22
 */
public class ReentrantLock3 {

    private Lock lock = new ReentrantLock();
    public Condition condition1 = lock.newCondition();
    public Condition condition2 = lock.newCondition();

    public void await1() {
        lock.lock();
        try {
            System.out.println("await1 begin时间为:" + MyDateTimeUtils.format(LocalDateTime.now())
                    + ",线程：" + Thread.currentThread().getName());
            condition1.await();//释放锁，进入等待状态
            System.out.println("await1 end时间为:" + MyDateTimeUtils.format(LocalDateTime.now())
                    + ",线程：" + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void await2() {
        lock.lock();
        try {
            System.out.println("await2 begin时间为:" + MyDateTimeUtils.format(LocalDateTime.now())
                    + ",线程：" + Thread.currentThread().getName());
            condition2.await();//释放锁，进入等待状态
            System.out.println("await2 end时间为:" + MyDateTimeUtils.format(LocalDateTime.now())
                    + ",线程：" + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll1() {
        lock.lock();
        try {
            System.out.println("signalAll1 时间为:" + MyDateTimeUtils.format(LocalDateTime.now())
                    + ",线程：" + Thread.currentThread().getName());
            condition1.signalAll();//获取锁
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll2() {
        lock.lock();
        try {
            System.out.println("signalAll2 时间为:" + MyDateTimeUtils.format(LocalDateTime.now())
                    + ",线程：" + Thread.currentThread().getName());
            condition2.signalAll();//获取锁
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
