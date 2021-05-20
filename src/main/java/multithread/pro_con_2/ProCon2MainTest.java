package multithread.pro_con_2;

/**
 * @author admin
 * @desc
 * @date 2019/7/22 10:02
 */
public class ProCon2MainTest {

    public static final int count = 15;

    public static void main(String[] args) {
        MyService service = new MyService();
        ThreadSet[] sets = new ThreadSet[count];
        ThreadGet[] gets = new ThreadGet[count];
        for (int i = 0; i < count; i++) {
            new ThreadSet(service).start();
            new ThreadGet(service).start();
        }


    }
}
