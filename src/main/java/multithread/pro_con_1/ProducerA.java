package multithread.pro_con_1;


/**
 * @author admin
 * @desc
 * @date 2019/7/21 23:56
 */
public class ProducerA extends Thread {

    private MyService myService;

    public ProducerA(MyService service1) {
        this.myService = service1;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            myService.set();
        }
    }
}
