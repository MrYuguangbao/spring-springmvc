package algorithm.offer;

import java.util.Scanner;

/**
 * @author admin
 * @date 2020/2/24 21:10
 */
public class OrderSolution {

    /**
     * 顺时针打印矩阵
     *
     * @param matrix
     * @return
     */
    public static int[][] spiralOrder(int[][] matrix) {
        int rowBegin = 0, rowEnd = matrix.length - 1;
        int colBegin = 0, colEnd = matrix[0].length - 1;
        int number = 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            //从左至右
            for (int i = colBegin; i <= colEnd; i++) {
                matrix[rowBegin][i] = number;
                number++;
            }
            rowBegin++;
            //从上至下
            for (int i = rowBegin; i <= rowEnd; i++) {
                matrix[i][colEnd] = number;
                number++;
            }
            colEnd--;
            //从右至左
            for (int i = colEnd; i >= colBegin; i--) {
                matrix[rowEnd][i] = number;
                number++;
            }
            rowEnd--;
            //从下至上
            for (int i = rowEnd; i >= rowBegin; i--) {
                matrix[i][colBegin] = number;
                number++;
            }
            colBegin++;
        }
        return matrix;
    }

    public static void showJuzhen(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input n:");
        int n = scanner.nextInt();
        while (n != -1) {
            int[][] matrix = new int[n][n];
            matrix = spiralOrder(matrix);
            System.out.println("顺时针打印矩阵");
            showJuzhen(matrix);
            System.out.print("input n:");
            n = scanner.nextInt();
        }

    }


}
