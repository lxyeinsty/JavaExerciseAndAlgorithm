package com.lixinyan.offer;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/24.
 *
 */
public class Huawei3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String seq = in.nextLine();
        int[] result = reverse(seq);
        if (seq.length() > 50) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            stringBuilder.append(String.valueOf(result[i]));
        }

        System.out.println(stringBuilder);
    }

    public static int[] reverse(String seq){
        int[] nums = new int[]{1,2,3,4,5,6};
        if (seq == null || seq.equals(""))
            return nums;

        for (int i = 0; i < seq.length(); i++){
            char c = seq.charAt(i);
            if (c == 'L' || c == 'A'){
                swap(nums, 0, 4);
                swap(nums, 1, 5);
                swap(nums, 4, 5);
            } else if (c == 'R' || c == 'C'){
                swap(nums, 0, 4);
                swap(nums, 1, 5);
                swap(nums, 0, 1);
            } else if (c == 'F') {
                swap(nums, 2, 4);
                swap(nums, 3, 5);
                swap(nums, 4, 5);
            } else if (c == 'B') {
                swap(nums, 2, 4);
                swap(nums, 3, 5);
                swap(nums, 2, 3);
            }
        }
        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
