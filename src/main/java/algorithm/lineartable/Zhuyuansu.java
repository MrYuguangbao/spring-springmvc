package algorithm.lineartable;

/**
 * @author admin
 * @date 2019/8/24 10:48
 */
public class Zhuyuansu {

    public static int query(int[] a, int n) {
        int c = a[0];
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] == c)
                ++count;
            else {
                if (count > 0)
                    --count;
                else {
                    c = a[i];
                    count = 1;
                }
            }

        }
        if (count > 0) {
            count = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == c) {
                    ++count;
                }
            }
        }
        if (count > n / 2) {
            return c;
        } else {
            return -1;
        }

    }

    public static void main(String[] args) {
        int[] a = {0, 5, 5, 3, 5, 5, 5, 1};
        System.out.println(query(a, a.length));
    }

}
