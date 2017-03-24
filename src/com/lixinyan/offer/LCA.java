package com.lixinyan.offer;

/**
 * Created by Administrator on 2017/3/22.
 *
 */
public class LCA {
    public int getLCA(int a, int b) {
        while (a != b) {
            if (a > b) {
                a /= 2;
            } else b = b / 2;
        }

        return a;
    }

}
