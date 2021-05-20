package multithread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 11:19
 */
public class AtomicIntegerTes {

    private static AtomicInteger i = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(i.getAndIncrement());
        System.out.println(i.get());

    }
}
