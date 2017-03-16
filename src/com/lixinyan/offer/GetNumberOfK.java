package com.lixinyan.offer;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/11.
 *
 */
public class GetNumberOfK {
    public int getNumberOfK(int [] array , int k) {
        int length = array.length;
        if (length <= 0 || array == null) {
            return 0;
        }

        int num = array[length / 2];
        int []  arrayLeft;
        int[] arrayRight;
        int count = 0;
        if (num > k) {
            try {
                arrayLeft = Arrays.copyOfRange(array, 0, length / 2);
                count = getNumberOfK(arrayLeft, k);
            } catch (IllegalArgumentException e) {
                count = 0;
            }

        } else if (num < k){
            try {
                arrayRight = Arrays.copyOfRange(array, length/2 + 1, length/2);
                count = getNumberOfK(arrayRight, k);
            } catch (IllegalArgumentException e) {
                count = 0;
            }
        }

        if (num == k) {
            count ++;
            int leftCount = 0;
            int rightCount = 0;
            int leftNum;
            int rightNum;

            for (int i = 1; i <= length/2; i++) {
                leftNum = array[length/2 - i];
                if (leftNum == k) {
                    leftCount++;
                } else {
                    break;
                }
            }

            count = count + leftCount;

            for (int i = 1; i <= length/2 - 1; i++) {
                rightNum = array[length/2 + i];
                if (rightNum == k) {
                    rightCount++;
                } else {
                    break;
                }
            }

            count = count + rightCount;
        }

        return count;
    }
}
