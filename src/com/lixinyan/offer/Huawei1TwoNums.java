package com.lixinyan.offer;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/24.
 *
 */
public class Huawei1TwoNums {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int sum = a + b;
            System.out.println(sum);
        }

        System.out.println("a");

    }

    public class Solution {
        /**
         * 交换数组里n和0的位置
         *
         * @param array
         *            数组
         * @param len
         *            数组长度
         * @param n
         *            和0交换的数
         */
        // 不要修改以下函数内容
        public void swapWithZero(int[] array, int len, int n) {

        }
        // 不要修改以上函数内容


        /**
         * 通过调用swapWithZero方法来排
         *
         * @param array
         *            存储有[0,n)的数组
         * @param len
         *            数组长度
         */
        public void sort(int[] array, int len) {
            if (len <= 1) {
                return;
            }
            for (int i = len - 1; i > 0; --i) {       //从最后一位开始，将最大的数放到最大位置上，然后依次找次大的放
                if (array[i] == i) continue;        //已经相等，则不交换,避免不必要的重复交换
                swapWithZero(array, len, array[i]); //现将0和最后一位交换，以便将第n最大值换到第n大位置上
                int curMax = array[i];
                for (int j = i; j >= 0; --j) {       //找出第n大的数
                    if (array[j] > curMax) {
                        curMax = array[j];
                    }
                }
                swapWithZero(array, len, curMax); //将第n大的数和0互换，从而放到第n大的位置上
            }
        }
    }

}
