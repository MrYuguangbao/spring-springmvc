package multithread.lock20190821;

/**
 * @author admin
 * @date 2019/8/21 17:40
 */
public class MainTest1 {

    public static void main(String[] args) throws Exception {
        ReentrantLock3 r3 = new ReentrantLock3();
        Thread1 t1 = new Thread1(r3);
        t1.setName("线程1");
        t1.start();
        Thread2 t2 = new Thread2(r3);
        t2.setName("线程2");
        t2.start();
        Thread.sleep(3000);
        r3.signalAll1();

    }
}
