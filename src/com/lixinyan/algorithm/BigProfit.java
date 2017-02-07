package com.lixinyan.algorithm;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/17.
 *
 */
public class BigProfit {

    public static void quicksort(int n[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quicksort(n, left, dp - 1);
            quicksort(n, dp + 1, right);
        }
    }

    public static int partition(int n[], int left, int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(",");
        int[] array = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            array[i] = Integer.parseInt(str[i]);
        }
        quicksort(array, 0, array.length - 1);
        System.out.print(array[array.length - 1] - array[0]);
    }
}