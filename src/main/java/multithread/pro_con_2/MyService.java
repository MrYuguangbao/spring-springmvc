package multithread.pro_con_2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 9:57
 */
public class MyService {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private boolean flag = false;

    public void set() {
        try {
            lock.lock();
            while (flag) {
                System.out.println("sss");
                condition.await();
            }
            System.out.println("s");
            flag = true;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void get() {
        try {
            lock.lock();
            while (!flag) {
                System.out.println("ggg");
                condition.await();
            }
            System.out.println("g");
            flag = false;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
