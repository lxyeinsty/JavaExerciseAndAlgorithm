package com.lixinyan.algorithm;

import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

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
        swap(data, index, end);

        int small = start - 1;

        for (index = start; index < end; index++) {
            if (data[index] < data[end]) {
                ++ small;
                if (small != index) {
                    swap(data, index, small);
                }
            }
        }

        ++small;
        swap(data, small, end);

        return small;
    }

    public static void swap(int [] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
        Objects.equals(1,2);
    }

    public static void main(String[] args) {
        int[] data = {1,2};
        swap(data, 0 , 1);
        System.out.print(data[0]);
        System.out.print(data[1]);
    }
}
