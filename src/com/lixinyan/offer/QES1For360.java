package com.lixinyan.offer;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/19.
 *
 */
public class QES1For360 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            float l = in.nextInt();
            float r = in.nextInt();
            // 这里分别求出cos(θ)和sin(θ)
            float x=(float)(r*Math.cos(l/r));
            float y=(float)(r*Math.sin(l/r));
            System.out.printf("%.3f %.3f\n",x,-y);
            System.out.printf("%.3f %.3f\n",x,y);
        }
        in.close();
    }
}
