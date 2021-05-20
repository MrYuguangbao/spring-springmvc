package multithread.pro_con_1;

import multithread.MyService1;

/**
 * @author admin
 * @desc
 * @date 2019/7/21 23:56
 */
public class ProducerB extends Thread {

    private MyService myService;

    public ProducerB(MyService service1) {
        this.myService = service1;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            myService.get();
        }
    }
}
