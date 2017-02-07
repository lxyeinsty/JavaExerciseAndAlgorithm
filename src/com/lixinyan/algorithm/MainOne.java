package com.lixinyan.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/12.
 *
 */
public class MainOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        List<Integer> list = new ArrayList<>();
        int[] a = new int[length];

        for (int i = 0; i < length; i++) {
            a[i] = in.nextInt();
            list.add(a[i]);
        }

    }
}
