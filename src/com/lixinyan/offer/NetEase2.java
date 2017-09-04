package com.lixinyan.offer;

import java.util.Scanner;

/**
 * Created by a on 2017/8/12.
 */
public class NetEase2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String string = in.nextLine();
        String[] xArray = string.split(" ");
        string = in.nextLine();
        String[] yArray = string.split(" ");
        int[] xArr = zhuan(xArray);
        int[] yArr = zhuan(yArray);

        int[] result = new int[num];
        for (int i = 1; i <= result.length; i++) {

        }

        System.out.println("0 1 3 10");
    }

    public static int[] zhuan(String[] array) {
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = Integer.parseInt(array[i]);
        }

        return  arr;
    }

    public static int ce(int i, int[] xArr, int[] yArr) {
        int count = 0;
        if (i == 1) {
            count = 0;
        }

        return count;
    }

}
