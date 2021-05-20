package multithread.condition1;

import util.MyDateTimeUtils;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 0:03
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println("awaitA begin时间：" + MyDateTimeUtils.format(LocalDateTime.now()));
            conditionA.await();
            System.out.println("awaitA end时间：" + MyDateTimeUtils.format(LocalDateTime.now()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println("awaitB begin时间：" + MyDateTimeUtils.format(LocalDateTime.now()));
            conditionB.await();
            System.out.println("awaitB end时间：" + MyDateTimeUtils.format(LocalDateTime.now()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_A() {
        try {
            lock.lock();
            System.out.println("signalAll_A 时间：" + MyDateTimeUtils.format(LocalDateTime.now()));
            conditionA.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_B() {
        try {
            lock.lock();
            System.out.println("signalAll_B 时间：" + MyDateTimeUtils.format(LocalDateTime.now()));
            conditionB.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
