package multithread;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 18:01
 */
public class DaemonTest {

    static class DameonThread implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("DameonThread finish");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new DameonThread(), "DaemonThread线程");
        thread.setDaemon(true);
        thread.start();

    }

}
