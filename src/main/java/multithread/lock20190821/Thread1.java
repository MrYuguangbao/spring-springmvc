package multithread.lock20190821;

/**
 * @author admin
 * @date 2019/8/21 17:39
 */
public class Thread1 extends Thread {
    private ReentrantLock3 r3;

    public Thread1(ReentrantLock3 r3) {
        this.r3 = r3;
    }

    @Override
    public void run() {
        r3.await1();
    }
}
