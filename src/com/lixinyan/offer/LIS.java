package com.lixinyan.offer;

/**
 * Created by lixinyan on 2017/8/28.
 * 最长递增子序列
 */
public class LIS {

    public static int listGet(int[] array) {
        int[] list = new int[array.length]; //用于记录当前个元素作为最大元素的最长递增序列的长度
        for (int i = 0; i < array.length; i++) {
            list[i] = 1;
        }
        int max = 1;
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && (list[j] + 1) > list[i]) {
                    list[i] = list[j] + 1;
                }
            }
            if (list[i] > max) {
                max = list[i];
                index = i;
            }
        }

        return max;

    }

    public static int[] toIntArray(String[] array) {
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = Integer.parseInt(array[i]);
        }

        return  arr;
    }

    public static void main(String[] args) {
        int[] array = {1,3,4,2,5};
        System.out.println(listGet(array));
    }
}
