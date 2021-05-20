package multithread.lock20190821;

/**
 * @author admin
 * @date 2019/8/21 17:57
 */
public class Thread4_1 extends Thread {

    private ReentrantLock4 r4;

    public Thread4_1(ReentrantLock4 r4) {
        this.r4 = r4;
    }

    @Override
    public void run() {
        r4.set();
    }
}
