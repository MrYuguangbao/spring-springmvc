package multithread.pro_con_1;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 0:22
 */
public class ConditionMain2 {
    public static void main(String[] args) {
        MyService myService = new MyService();
        ProducerA producerA = new ProducerA(myService);
        producerA.start();
        ProducerB producerB = new ProducerB(myService);
        producerB.start();

    }
}
