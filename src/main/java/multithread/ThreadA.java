package multithread;

/**
 * @author admin
 * @desc
 * @date 2019/7/21 23:56
 */
public class ThreadA extends Thread {

    private MyService1 myService1;

    public ThreadA(MyService1 service1) {
        this.myService1 = service1;
    }

    @Override
    public void run() {
        myService1.method1();
    }
}
