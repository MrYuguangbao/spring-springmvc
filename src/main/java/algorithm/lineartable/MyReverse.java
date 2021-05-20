package algorithm.lineartable;

/**
 * @author admin
 * @date 2019/8/24 0:23
 */
public class MyReverse {

    public static String leftMove(char[] chars, int p) {
        String s = String.valueOf(chars);
        StringBuffer part1 = new StringBuffer(s.substring(0, p)).reverse();
        StringBuffer part2 = new StringBuffer(s.substring(p)).reverse();
        StringBuffer part3 = new StringBuffer(part1.append(part2)).reverse();
        return part3.toString();
    }

    public static void main(String[] args) {
        String s = "abcdefgh";
        System.out.println(s.substring(0, 3));
        System.out.println(leftMove(s.toCharArray(), 3));
    }

}
