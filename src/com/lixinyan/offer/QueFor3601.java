package com.lixinyan.offer;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/25.
 *
 */
public class QueFor3601 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String strings = in.nextLine();
            String[] nums = strings.split(" ");
            hashMap.put(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
        }

        double sum  = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            sum = sum + ((double)entry.getKey() * ((double)entry.getValue() / 100));
        }

        BigDecimal b = new BigDecimal(sum);
        double sum1 = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.printf("%.3f\n", sum1);
    }
}
