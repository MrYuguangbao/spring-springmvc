package multithread.concurrentutil.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author admin
 * @date 2020/1/10 18:48
 */
public class CyclicBarrier1 {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new A());

    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ".run...3");
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + ".run...1");
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            System.out.println(Thread.currentThread().getName() + ".run...2");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }


    }

}
