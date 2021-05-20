package multithread.condition1;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 0:08
 */
public class ThreadB extends Thread {
    private MyService service;

    public ThreadB(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitB();
    }
}
