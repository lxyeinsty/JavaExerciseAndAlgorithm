package com.lixinyan.offer;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/2/13.
 *
 */
public class FindGreateattestSumOFArray {
    public static int findGreateatSumOfArray(int[] data) {
        if (data.length == 0) {
            return 0;
        }

        int curSum = 0;
        int maxSum = data[0];

        for (int i = 0; i < data.length; i++) {
            if (curSum <= 0) {
                curSum = data[i];
            } else {
                curSum = curSum + data[i];
            }

            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] array = toIntArray(line.split(" "));
        System.out.println(findGreateatSumOfArray(array));
    }

    public static int[] toIntArray(String[] array) {
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = Integer.parseInt(array[i]);
        }

        return  arr;
    }
}
