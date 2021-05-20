package multithread;

/**
 * @author admin
 * @desc
 * @date 2019/7/21 23:58
 */
public class RunMain1 {

    public static void main(String[] args) {
        MyService1 service1 = new MyService1();
        ThreadA threadA = new ThreadA(service1);
        threadA.setName("threadA");
        threadA.start();

        ThreadAA threadAA = new ThreadAA(service1);
        threadAA.setName("threadAA");
        threadAA.start();


    }
}
