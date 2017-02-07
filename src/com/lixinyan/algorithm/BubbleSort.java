package com.lixinyan.algorithm;

import java.util.Scanner;

/**
 * Created by administrator on 2016/4/20.
 *
 */
public class BubbleSort {
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

        int temp;
        for (int i = 0; i < a.length; i++) { //趟数
            for (int j = 0; j < a.length -i - 1; j++) { //比较次数
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }

        double endTime = System.currentTimeMillis();

        System.out.println("运行时间" + (endTime - startTime));
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + "   ");
        }
    }
}
