package com.lixinyan.offer;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/19.
 *
 */
public class PingDuoDuo1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i1, i2, j1, j2 = 0;
        int offset = in.nextInt(); //已经使用数量
        int n = in.nextInt(); //还需数量
        int len1 = in.nextInt();
        int len2 = in.nextInt();

        int a = len1 - offset;
        if (a >= 0) {
            i1 = offset;
            if ((offset + n) <= len1) {
                i2 = offset + n;
                j1 = len2;
                j2 = len2;
            } else {
                if ((n - a) <= len2) {
                    i2 = len1;
                    j1 = 0;
                    j2 = (n - a);
                } else {
                    i2 = len2;
                    j1 = 0;
                    j2 = len2;
                }
            }
        } else {
            if (a > len2) {
                i1 = len1;
                i2 = len1;
                j1 = len2;
                j2 = len2;
            } else {
                a = offset - len1;
                i1 = len1;
                i2 = len1;
                j1 = a;
                if ((len2 - a) >= n) {
                    j2 = a + n;
                } else {
                    j2 = len2;
                }
            }
        }

        System.out.println(i1 + " "  + i2 + " " + j1 + " " + j2);
    }
}
