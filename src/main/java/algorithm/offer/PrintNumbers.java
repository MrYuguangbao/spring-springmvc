package algorithm.offer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author admin
 * @date 2020/2/22 19:46
 */
public class PrintNumbers {

    /**
     * 方法1
     *
     * @param n
     * @throws Exception
     */
    public static void printOneToMax_1(int n) throws Exception {
        if (n <= 0) throw new Exception("n must be more than zero!");
        char[] number = new char[n];
        Arrays.fill(number, '0');
        while (!increment(number)) {
            printNumber(number);
        }
    }

    /**
     * 使用数组实现对数字+1
     *
     * @param number
     * @return
     */
    public static boolean increment(char[] number) {
        boolean overFlow = false;
        int carry = 0;
        int len = number.length;
        for (int i = len - 1; i >= 0; i--) {
            char c = number[i];
            int sum = c - '0' + carry;
            if (i == len - 1) {
                sum++;
            }
            //进位
            if (sum >= 10) {
                if (i == 0) {
                    overFlow = true;
                } else {
                    sum -= 10;
                    number[i] = (char) ('0' + sum);
                    carry = 1;
                }
            } else {
                number[i] = (char) ('0' + sum);
                break;
            }
        }
        return overFlow;
    }

    /**
     * 打印1到最大的n位数，使用全排列
     *
     * @param n
     */
    public static void printOneToMax_2(int n) throws Exception {
        if (n <= 0) {
            throw new Exception("n must be more than zero!");
        }
        ;
        char[] number = new char[n];
        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            printRecursively(number, n, 0);
        }
    }

    /**
     * 全排列递归
     *
     * @param number
     * @param length
     * @param index
     */
    public static void printRecursively(char[] number, int length, int index) {
        if (index == length - 1) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + '0');
            printRecursively(number, length, index + 1);
        }
    }

    /**
     * 如果数组中表示的数字位数小于n,则不打印前面的0
     *
     * @param number
     */
    public static void printNumber(char[] number) {
        boolean isBegin = true;
        int len = number.length;
        for (int i = 0; i < len; i++) {
            if (isBegin && number[i] != '0') {
                isBegin = false;
            }
            if (!isBegin) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input n:");
        int n = scanner.nextInt();
        try {
            printOneToMax_1(n);
            //printOneToMax_2(n);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
