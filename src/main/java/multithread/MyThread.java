package multithread;

/**
 * @author admin
 * @desc
 * @date 2019/7/21 23:49
 */
public class MyThread extends Thread {

    private MyService myService;

    public MyThread(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}
