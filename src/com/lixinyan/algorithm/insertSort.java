package com.lixinyan.algorithm;

import java.util.Scanner;

/**
 * Created by administrator on 2016/4/20.
 *
 */
public class insertSort {
    public static void main(String[] args) {

        Scanner in =  new Scanner(System.in);
        System.out.println("请输入要排序的一组数据的长度");

        int n = in.nextInt();
        int[] a = new int[n];

        System.out.println("请输入你要排序的数组");
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }

        double startTime = System.currentTimeMillis();

        int tem, j, p;
        for (p=1; p < a.length; p++) {
            tem = a[p];
            for (j = p; j > 0 && a[j - 1] > tem ; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tem;
        }

        double endTime = System.currentTimeMillis();

        System.out.println("运行时间" + (endTime - startTime));
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + "   ");
        }

    }
}
