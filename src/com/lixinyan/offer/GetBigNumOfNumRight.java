package com.lixinyan.offer;

import java.util.Stack;

/**
 * Created by asus on 2017/4/29.
 *
 */
public class GetBigNumOfNumRight {
    public static final int NAN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] data = {9, 6, 5, 10, 3, 2, 1, 5, 9, 10};
        int[]  res =  getTheRightBiggerNum(data);
        for (int i = 0; i < res.length; i++) {
            if (res[i] == NAN) {
                System.out.print("N" + " ");
            } else {
                System.out.print(res[i] + " ");
            }
        }
    }

    public static int[] getTheRightBiggerNum(int[] array) {
        int length = array.length;
        int[] arrayList = new int[length];

        if (length == 0) {
            return arrayList;
        }

        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i < length) {
            if (stack.isEmpty() || array[i] <= array[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                arrayList[stack.pop()]  = array[i];
            }
        }

        while (!stack.isEmpty()) {
            arrayList[stack.pop()] = NAN;
        }

        return arrayList;
    }
}
