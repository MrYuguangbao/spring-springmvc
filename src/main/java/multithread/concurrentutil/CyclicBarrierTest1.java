package multithread.concurrentutil;

import multithread.pro_con_2.ThreadGet;
import util.MyDateTimeUtils;

import java.time.LocalDateTime;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 16:15
 */
public class CyclicBarrierTest1 {
    public static final int count = 4;
    public static CyclicBarrier barrier = new CyclicBarrier(count);

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < count; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据，当前时间" + MyDateTimeUtils.format(LocalDateTime.now()));
                    try {
                        Thread.sleep(2000);
                        System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其它线程写入数据，当前时间" + MyDateTimeUtils.format(LocalDateTime.now()));
                        barrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "所有线程写入数据完毕，处理其它任务。。。");
                }
            });
            t.start();
        }
        Thread.sleep(2000);
        /*System.out.println("barrier重用");
        for (int i = 0; i < count; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据，当前时间"+MyDateTimeUtils.format(LocalDateTime.now()));
                    try{
                        Thread.sleep(2000);
                        System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其它线程写入数据，当前时间"+MyDateTimeUtils.format(LocalDateTime.now()));
                        barrier.await();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("所有线程写入数据完毕，处理其它任务。。。");
                }
            });
            t.start();
        }*/
    }
}
