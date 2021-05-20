package multithread.pro_con_2;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 10:02
 */
public class ThreadGet extends Thread {
    private MyService service;

    public ThreadGet(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.get();
    }
}
