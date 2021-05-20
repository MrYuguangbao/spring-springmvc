package multithread.pro_con_2;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 10:01
 */
public class ThreadSet extends Thread {

    private MyService service;

    public ThreadSet(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.set();
    }
}
