package com.springtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 * @desc
 * @date 2019/7/19 23:31
 */
public class NULL {


    public int show() {
        int a = 1;
        int b = 2;
        int c = (a + b) / 5;
        return c;
    }

    public static void main(String[] args) {

        List<Integer> test = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            test.add(i);
        }
        Integer[] arr = new Integer[test.size()];
        test.toArray(arr);

        System.out.println(Arrays.toString(arr));
    }

}
