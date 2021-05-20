package com.springtest.lock;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 8:24
 */
public class FairAndUnFairTest {

    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);

    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public Collection<Thread> getQueuedThreads() {
            List<Thread> list = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(list);
            return list;
        }
    }

    private static class Job extends Thread {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = 0; i < 2; i++) {
                System.out.print("当前线程：" + Thread.currentThread().getName() + ", 等待队列中的线程：");
                Collection<Thread> threads = ((ReentrantLock2) lock).getQueuedThreads();
                threads.stream().forEach(ele -> System.out.print(ele.getName() + ","));
            }
        }
    }

    private void testLock(Lock lock) {
        Job job1 = new Job(lock);
        job1.setName("1");
        Job job2 = new Job(lock);
        job2.setName("2");
        Job job3 = new Job(lock);
        job3.setName("3");
        Job job4 = new Job(lock);
        job4.setName("4");
        Job job5 = new Job(lock);
        job5.setName("5");
        job1.start();
        job2.start();
        job3.start();
        job4.start();
        job5.start();
    }

    @Test
    public void fair() {
        System.out.println("--------------- 公平锁 ---------------");
        testLock(fairLock);
    }

    @Test
    public void unfair() {
        System.out.println("--------------- 非公平锁 ---------------");
        testLock(unfairLock);
    }

    /*public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        System.out.println(list.toString());

    }*/

}
