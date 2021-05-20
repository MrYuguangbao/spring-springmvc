package multithread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author admin
 * @date 2019/8/21 23:02
 */
public class ExchangerTest {

    private static Exchanger<String> exchanger = new Exchanger<>();
    private static ExecutorService service = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                String a = "银行流水A";
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
                try {
                    String b = "银行流水b";
                    String a = exchanger.exchange(b);
                    System.out.println("a是否和b一致" + a.equals(b));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        service.shutdown();
    }

}
