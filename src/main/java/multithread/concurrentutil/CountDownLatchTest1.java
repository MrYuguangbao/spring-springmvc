package multithread.concurrentutil;

import util.MyDateTimeUtils;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 16:05
 */
public class CountDownLatchTest1 {
    public static final CountDownLatch latch = new CountDownLatch(2);
    public static final ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("子线程：" + Thread.currentThread().getName() + "正在执行，当前时间" + MyDateTimeUtils.format(LocalDateTime.now()));
                        Thread.sleep(2000);
                        System.out.println("子线程：" + Thread.currentThread().getName() + "执行完毕，当前时间" + MyDateTimeUtils.format(LocalDateTime.now()));
                        latch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        try {
            System.out.println("等待线程池执行完毕");
            latch.await();
            System.out.println("线程池执行完毕，执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();

    }
}
