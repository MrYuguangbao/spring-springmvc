package multithread.condition1;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 0:08
 */
public class ConditionMain1 {
    public static void main(String[] args) throws Exception {
        MyService service = new MyService();
        ThreadA threadA = new ThreadA(service);
        threadA.setName("A");
        threadA.start();

        ThreadB threadB = new ThreadB(service);
        threadB.setName("B");
        threadB.start();
        Thread.sleep(3000);
        service.signalAll_A();


    }

}
