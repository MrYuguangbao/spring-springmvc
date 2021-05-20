package algorithm.offer;

import java.util.Arrays;

/**
 * @author admin
 * @date 2020/2/21 17:19
 */
public class sanjiaoxing {

    public int partition(int[] n, int low, int high) {
        int temp = n[low];
        while (low < high) {
            while (low < high && temp >= n[high]) {
                --high;
            }
            n[low] = n[high];
            while (low < high && temp <= n[low]) {
                ++low;
            }
            n[high] = n[low];
        }
        n[low] = temp;
        return low;
    }

    public void sort(int[] n, int low, int high) {
        if (low < high) {
            int pivot = partition(n, low, high);
            sort(n, low, pivot - 1);
            sort(n, pivot + 1, high);
        }
    }

    public void search(int[] n) {


    }

    public static void main(String[] args) {
        sanjiaoxing s = new sanjiaoxing();
        int[] array = {14, 25, 13, 8, 12, 9, 10, 5, 11, 6};
        s.sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length - 2; i++) {
            if (array[i] - array[i + 1] < array[i + 2]) {
                int result = array[i] + array[i + 1] + array[i + 2];
                System.out.print("能组成三角形的三边：" + array[i] + "," + array[i + 1] + "," + array[i + 2]);
                System.out.println(" 周长是：" + result);
            }

        }

        System.out.println(13 * 13 == 12 * 12 + 5 * 5);
    }


}
