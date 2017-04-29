package com.lixinyan.offer;

/**
 * Created by Administrator on 2017/2/13.
 *
 */
public class MergeSort {
    public void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }

    public  int[] sort(int[] nums, int low, int hign) {
        int mid = (low + hign) / 2;

        if (low < hign) {
            sort(nums, low, mid);
            sort(nums, mid + 1, hign);
            merge(nums, low, mid, hign);
        }

        return nums;
    }
}
