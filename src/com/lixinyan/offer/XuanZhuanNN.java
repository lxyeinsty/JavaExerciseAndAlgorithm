package com.lixinyan.offer;

/**
 * Created by lxy on 2017/8/28.
 * 打印旋转数组
 */
public class XuanZhuanNN {

    public void printNN(int N) {
        if (N <= 1) return;

        int[] p = new int[N * N];
        int i = 0, j = 0;
        int cnt = 1;
        int m = N;

        while (m >= (N + 1) / 2) {
            while (j < m) {
                p[i * N + j++] = cnt++;
            }
        }
    }
}
