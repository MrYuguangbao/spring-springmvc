package multithread.lock20190821;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author admin
 * @date 2019/8/21 17:53
 */
public class ReentrantLock4 {

    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    private boolean hasValue = false;

    public void set() {
        lock.lock();
        try {
            while (hasValue == true) {
                //System.out.println("set1");
                condition.await();
                //System.out.println("set2");
            }
            System.out.println("****");
            hasValue = true;
            condition.signal();
            System.out.println("--------------------set--------------------");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        lock.lock();
        try {
            while (hasValue == false) {
                //System.out.println("get1");
                condition.await();
                //System.out.println("get2");
            }
            System.out.println("@@@@");
            hasValue = false;
            condition.signal();
            System.out.println("--------------------get--------------------");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock4 r4 = new ReentrantLock4();
        new Thread4_1(r4).start();
        new Thread4_2(r4).start();
    }

}
