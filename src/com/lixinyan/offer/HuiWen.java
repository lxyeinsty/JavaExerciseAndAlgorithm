package com.lixinyan.offer;

/**
 * Created by lxy on 2017/8/6.
 *
 */

//int[] arr 数组，如果不是回文，规定通过以下方式使其成为回文：任意选择arr 相邻两个数相加的到和sum，
//将sum替换这相邻的两个数，得到新数组arr',看至少通过多少次这样的运算方式使其成为回文数组。


public class HuiWen {
    public int resolve(int[] array, int n) { //返回交换次数成为回文数组
        int count = 0;
        if (array == null || array.length < 2) {
            return count;
        }

        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] == array[right]) {
                left++;
                right--;
            } else if (array[left] < array[right]) {
                int sum = array[left] + array[left + 1];
                left++;
                array[left] = sum;
                count++;
            } else {
                int sum = array[right - 1] + array[right];
                right--;
                array[right] = sum;
                count++;
            }
         }

         return count;
    }
}

