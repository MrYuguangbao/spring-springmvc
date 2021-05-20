package multithread.concurrentutil;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 15:24
 */
public class CyclicBarrierTest2 implements Runnable {

    private CyclicBarrier c = new CyclicBarrier(4, this);

    private ExecutorService executor = Executors.newFixedThreadPool(4);// 处理任务的线程数

    private static ConcurrentHashMap<String, Integer> result = new ConcurrentHashMap<String, Integer>();// 每个任务的计算结果

    @Override
    public void run() {
        int tmp = 0;
        for (Map.Entry<String, Integer> stringIntegerEntry : result.entrySet()) {
            tmp += stringIntegerEntry.getValue();
        }
        result.put("tmp", tmp);
        System.out.println("-- tmp -- :" + tmp);
        for (Map.Entry<String, Integer> stringIntegerEntry : result.entrySet()) {
            System.out.println("key:" + stringIntegerEntry.getKey() + ",value:" + stringIntegerEntry.getValue());
        }
    }

    public void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    result.put(Thread.currentThread().getName(), 1);
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
        executor.shutdown();
    }

    public static void main(String[] args) {
        CyclicBarrierTest2 test = new CyclicBarrierTest2();
        test.count();
    }
}
