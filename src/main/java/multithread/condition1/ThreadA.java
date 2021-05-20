package multithread.condition1;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 0:08
 */
public class ThreadA extends Thread {
    private MyService service;

    public ThreadA(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitA();
    }
}
