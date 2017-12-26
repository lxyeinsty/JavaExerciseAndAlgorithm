package com.lixinyan.algorithm;

import java.util.List;
import java.util.Scanner;

/**
 * Created by administrator on 2016/4/20.
 *
 */
public class LargestSubsegmentSuml {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入你要求得序列的长度");
        int n = in.nextInt();

        int[] a = new int[n];
        System.out.println("现在请输入你要求和的序列");
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }

        double startTime = System.currentTimeMillis();

//		int maxSum = a[0];
//		for (int i = 0; i < n - 1; i++) {
//			int temp = a[i];
//			for (int j = i + 1; j < n; j++) {
//				temp += a[j];
//				if (temp > maxSum) {
//					maxSum = temp;
//				}
//			}
//		}

        int maxSum = 0;
        int[] b = new int[n];
        b[0] = 0;
        for (int j = 1; j < n; j++) {
            if (b[j-1] > 0) {
                b[j] = b[j - 1] + a[j];
            } else {
                b[j] = a[j];
            }
        }

        for (int j = 0; j < n; j++) {
            if (b[j] > maxSum) {
                maxSum = b[j];
            }
        }

        double endTime = System.currentTimeMillis();

        System.out.println("结果是" + maxSum);
        System.out.println("算法时间是" + (endTime - startTime));
    }


}
