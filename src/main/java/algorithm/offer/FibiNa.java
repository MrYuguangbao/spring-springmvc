package algorithm.offer;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author admin
 * @date 2020/2/21 15:32
 */
public class FibiNa {

    public static int[] findItems(int n) {
        int index = 0;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1) {
                array[i] = 1;
            } else {
                array[i] = array[i - 1] + array[i - 2];
            }
        }
        return array;
    }

    public static void main(String[] args) {
        InputStream in = System.in;
        Scanner scanner = new Scanner(in);
        System.out.println("输入n:");
        int n = scanner.nextInt();
        int[] items = findItems(n);
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(items[i] + " ");
        }
    }

}
