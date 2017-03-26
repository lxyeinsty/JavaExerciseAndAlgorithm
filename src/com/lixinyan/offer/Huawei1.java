package com.lixinyan.offer;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/24.
 *
 */
public class Huawei1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        String[] strings = input.split(",");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
            if (nums[i] < 1 || nums[i] > 70000) {
                System.out.println(-1);
                return;
            }
        }


        System.out.println(reverseAdd(nums[0], nums[1]));
    }

    public static int reverseAdd(int a, int b) {
        int m = reverse(a);
        int n = reverse(b);

        return m + n;
    }

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }

            result = newResult;
            x = x / 10;
        }

        return result;
    }

}
