package com.lixinyan.offer;

import java.util.Arrays;

/**
 * Created by asus on 2017/4/30.
 *
 */
public class FindNumApperanceOnceOtherNumApperanceThree {

    public static void main(String[] args) {
        int[] data = new int[]{1,1,1,2,2,2,8,5,5,5,7,7,7};
        System.out.println(findNum(data));
    }

    public static int findNum(int[] nums) {
        int[] bits = new int[32];
        Arrays.fill(bits, 0);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                bits[j] = bits[j] + ((nums[i] >> j) & 1);
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] % 3 != 0) {
                result = result + (1 << i);
            }
        }

        return result;
    }
}