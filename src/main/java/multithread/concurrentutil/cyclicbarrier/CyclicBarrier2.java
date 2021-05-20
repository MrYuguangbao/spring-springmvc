package multithread.concurrentutil.cyclicbarrier;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author admin
 * @date 2020/1/10 19:00
 */
public class CyclicBarrier2 implements Runnable {

    public static final int COUNT = 4;
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(COUNT, this::run);
    private static ExecutorService service = new ThreadPoolExecutor(COUNT, COUNT, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

    private ConcurrentHashMap<String, Integer> countMap = new ConcurrentHashMap<>();


    private void count() {
        for (int i = 0; i < COUNT; i++) {
            service.execute(() -> {
                countMap.put(Thread.currentThread().getName(), 1);
                System.out.println(Thread.currentThread().getName() + ".count");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始汇总结果");
        int result = 0;
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            result += entry.getValue();
        }
        countMap.put("result", result);
        System.out.println("result:" + result);
    }


    public static void main(String[] args) {
        CyclicBarrier2 barrier2 = new CyclicBarrier2();
        barrier2.count();
        service.shutdown();
    }
}
