package com.lixinyan.offer;

/**
 * Created by Administrator on 2017/2/13.
 *
 */
public class FindGreateattestSumOFArray {
    int findGreateatSumOfArray(int[] data) {
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
}
