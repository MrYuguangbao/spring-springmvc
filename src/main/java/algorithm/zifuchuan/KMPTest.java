package algorithm.zifuchuan;

/**
 * @author admin
 * @date 2019/8/22 12:22
 */
public class KMPTest {

    public static int KMPsearch(char[] s, char[] p, int[] next) {
        int i = 0, j = 0;
        while (i < s.length && j < p.length) {
            if (j == -1 || s[i] == p[j]) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int[] getNext(char[] p) {
        int[] next = new int[p.length];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < p.length - 1) {
            if (k == -1 || p[k] == p[j]) {
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String s = "BBC ABCDAB ABCDABCDABDE";
        String p = "ABCDAB";
        char[] zhu = s.toCharArray();
        char[] pattern = p.toCharArray();

        for (int i = 0; i < zhu.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < zhu.length; i++) {
            System.out.print(zhu[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < pattern.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < pattern.length; i++) {
            System.out.print(pattern[i] + " ");
        }
        System.out.println();
        int[] result = getNext(pattern);
        System.out.println("匹配位置：" + KMPsearch(zhu, pattern, result));


    }

}
