package algorithm.zifuchuan;

/**
 * @author admin
 * @date 2019/8/22 13:04
 */
public class SearchString1 {
    public static int search1(char[] s, char[] p) {
        int i = 0, j = 0;
        while (i < s.length && j < p.length) {
            if (s[i] == p[j]) {
                ++i;
                ++j;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String s = "BBC ABCDAB ABCDABCDABDE";
        String p = "ABCDABD";
        char[] zhu = s.toCharArray();
        char[] pattern = p.toCharArray();
        System.out.println("匹配位置：" + search1(zhu, pattern));

    }
}
