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
public class ReentrantLock2 implements Runnable {

    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    public void await() {
        lock.lock();
        try {
            System.out.println("await1时间为:" + MyDateTimeUtils.format(LocalDateTime.now()));
            condition.await();//释放锁，进入等待状态
            System.out.println("await2时间为:" + MyDateTimeUtils.format(LocalDateTime.now()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signal() {
        lock.lock();
        try {
            System.out.println("signal1时间为:" + MyDateTimeUtils.format(LocalDateTime.now()));
            condition.signal();//获取锁
            System.out.println("signal2时间为:" + MyDateTimeUtils.format(LocalDateTime.now()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    @Override
    public void run() {
        await();
    }

    public static void main(String[] args) throws Exception {
        ReentrantLock2 r1 = new ReentrantLock2();
        new Thread(r1).start();
        Thread.sleep(3000);
        r1.signal();
    }

}
