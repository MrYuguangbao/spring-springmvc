package multithread.countdownlatch;

import java.util.concurrent.*;

/**
 * @author admin
 * @date 2020/1/10 18:28
 */
public class CountDownLatch1 {

    public static final int COUNT = 10;

    public static void main(String[] args) {
        final CountDownLatch begin = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(COUNT);

        ExecutorService service = new ThreadPoolExecutor(COUNT, COUNT, 0,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());


        for (int i = 0; i < COUNT; i++) {
            int no = i + 1;
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {
                        //begin.await();
                        Thread.sleep(2000);
                        System.out.println("No:" + no + "-arrived");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                }
            };
            service.submit(task);
        }
        System.out.println("start....");
        try {
            //begin.countDown();
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end....");
        service.shutdown();
    }


}
