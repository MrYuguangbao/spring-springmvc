package multithread.concurrentutil;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 15:49
 */
public class ExchangerTest {
    private static final Exchanger<String> exchanger = new Exchanger<String>();
    private static ExecutorService service = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                String a = "银行流水a";
                try {
                    exchanger.exchange(a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                String b = "银行流水b";
                try {
                    String a = exchanger.exchange(b);
                    System.out.println("a和b是否一致:" + a.equals(b) + ",a存放的是:" + a + ",b存放的是:" + b);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        service.shutdown();
    }

}
