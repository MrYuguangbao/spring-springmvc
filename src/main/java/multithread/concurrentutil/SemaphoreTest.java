package multithread.concurrentutil;

import util.MyDateTimeUtils;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 15:41
 */
public class SemaphoreTest {
    private static ExecutorService service = Executors.newFixedThreadPool(8);

    private static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            int t = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(t + 1 + ":获取，当前时间：" + MyDateTimeUtils.format(LocalDateTime.now()));
                        Thread.sleep(2000);
                        System.out.println(t + 1 + ":释放，当前时间：" + MyDateTimeUtils.format(LocalDateTime.now()));
                        semaphore.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }
        service.shutdown();
    }

}
