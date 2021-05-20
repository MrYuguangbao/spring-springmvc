package multithread.concurrentutil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 15:13
 */
public class CyclicBarrierTest {
    public static CyclicBarrier barrier = new CyclicBarrier(2, new A());

    public static class A implements Runnable {
        @Override
        public void run() {
            System.out.println(3);
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();

        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }

}
