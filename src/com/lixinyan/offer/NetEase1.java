package com.lixinyan.offer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/25.
 *
 */
public class NetEase1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string  = in.nextLine();
        String[] array = string.split(" ");
        int x = Integer.parseInt(array[0]);
        int f = Integer.parseInt(array[1]);
        int d = Integer.parseInt(array[2]);
        int p = Integer.parseInt(array[3]);

        int result = (d + f * p) / (p + x);
        System.out.println(result);
    }

}
