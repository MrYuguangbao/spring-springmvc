package algorithm.offer;

/**
 * @author admin
 * @date 2020/2/18 16:53
 */
public class Offer4 {

    public static String substitute(String original) {
        if (original == null) {
            return null;
        }
        char[] chars = original.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char aChar : chars) {
            if (Character.isWhitespace(aChar)) {
                builder.append("%20");
                continue;
            }
            builder.append(aChar);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String original = "We are family";
        String substitute = substitute(original);
        System.out.println("替换结果：" + substitute);

    }


}
