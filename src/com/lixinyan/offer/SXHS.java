package com.lixinyan.offer;

/**
 * Created by Administrator on 2017/4/7.
 *
 */
public class SXHS {
    public static void main(String args[]){
        int sum = 0;
        int count = 0;
        for (int i = 100; i < 1000; i++) {
            int a =  i % 10;
            int b = (i / 10) % 10;
            int c = i  / 100;
            if (a*a*a+b*b*b+c*c*c == i) {
                count++;
                sum = sum + i;
                System.out.println("第" + count + "个水仙花数: " + i);
            }
        }

        System.out.println("水仙花数总和为: " + sum);
    }
}
