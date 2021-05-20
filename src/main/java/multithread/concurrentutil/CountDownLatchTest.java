package multithread.concurrentutil;

import java.util.concurrent.CountDownLatch;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 15:00
 */
public class CountDownLatchTest {

    public static CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                latch.countDown();
                System.out.println(2);
                latch.countDown();
            }
        }).start();
        latch.await();
        System.out.println(3);

    }


}
