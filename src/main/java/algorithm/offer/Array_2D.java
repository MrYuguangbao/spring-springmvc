package algorithm.offer;

/**
 * @author admin
 * @date 2019/8/24 18:10
 */
public class Array_2D {

    static int resultRow = 0, resultColumn = 0;

    /**
     * 查找key在二维数组中是否存在
     *
     * @param a
     * @param key
     * @return
     */
    public boolean find(int[][] a, int key) {
        int row = 0, col = a[0].length - 1;
        while (col >= 0 && row < a.length) {
            if (a[row][col] == key) {
                resultRow = row + 1;
                resultColumn = col + 1;
                return true;
            } else {
                if (key < a[row][col]) {
                    col--;
                }
                if (key > a[row][col]) {
                    row++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Array_2D array_2D = new Array_2D();
        int[][] a = {
                {32, 46, 51, 61, 78, 199},
                {132, 146, 151, 161, 178, 299},
                {232, 246, 251, 261, 278, 399},
                {332, 346, 351, 361, 378, 499},
                {432, 446, 451, 461, 478, 599}
        };
        if (array_2D.find(a, 132))
            System.out.println("位置是：" + resultRow + "行" + resultColumn + "列");
        else
            System.out.println("不存在该元素");
    }


}
