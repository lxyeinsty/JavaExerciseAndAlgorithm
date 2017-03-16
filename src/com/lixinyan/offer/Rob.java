package com.lixinyan.offer;

/**
 * Created by Administrator on 2017/3/14.
 *
 */
//动态规划：重叠子问题+最优子结构，将递归记化 O(M*N) n部迭代，每步迭代需要计算m各子项
public class Rob {  //给定一个数组，找出最大和串，每两个数字不能相邻
    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] mark = new int[nums.length];
        mark[0] = nums[0];
        mark[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            mark[i] = Math.max(nums[i] + mark[i - 2], mark[i - 1]);
        }

        return mark[nums.length - 1];
    }
}
