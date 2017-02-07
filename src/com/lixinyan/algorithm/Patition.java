package com.lixinyan.algorithm;

import java.security.InvalidAlgorithmParameterException;

/**
 * Created by Administrator on 2016/11/28.
 *
 */
public class Patition {
    @SuppressWarnings("all")
    public static int patition(int[] data, int lenth, int start, int end) {

        if (data == null || lenth <= 0 || start < 0 || end >= lenth) {
            //throw new InvalidAlgorithmParameterException();
        }

        int index = (int) Math.random() * (end - start) + start;
        swap(data[index], data[end]);

        int small = index - 1;

        for (index = start; index < end; index++) {
            if (data[index] < data[end]) {
                ++ small;
                if (small != index) {
                    swap(data[index], data[small]);
                }
            }
        }

        ++small;
        swap(data[small], data[end]);

        return small;
    }

    public static void swap(int a, int b) {
        int temp;
        temp = a;
        a = b;
        b = temp;
    }
}
