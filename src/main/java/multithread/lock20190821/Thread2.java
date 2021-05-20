package multithread.lock20190821;

/**
 * @author admin
 * @date 2019/8/21 17:39
 */
public class Thread2 extends Thread {
    private ReentrantLock3 r3;

    public Thread2(ReentrantLock3 r3) {
        this.r3 = r3;
    }

    @Override
    public void run() {
        r3.await2();
    }
}
