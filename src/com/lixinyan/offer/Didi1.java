package com.lixinyan.offer;

import java.util.Scanner;

/**
 * Created by asus on 2017/5/7.
 */
public class Didi1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        int m = Integer.parseInt(string.split(" ")[0]);
        int n = Integer.parseInt(string.split(" ")[1]);

        int[][] array = new int[m][n];

        for (int i = 0; i < m; i++) {
            String s = in.nextLine();
            String[] strings = s.split("");
            int[] a = new int[n];
            for (int j = 0; j < strings.length; j++) {
                a[j] = Integer.parseInt(strings[j]);
            }
            array[i] = a;
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 1) {

                    if (array[i - 1][j] == 0 && array[i + 1][j] == 0
                            && array[i][j - 1] == 0 && array[i][j + 1] ==0) {
                        result = result+1;
                    }


//                    if ((i - 1 < 0 && i + 1 >= m)) {
//
//                    } else if ((j - 1 < 0 && j + 1 >= n)) {
//
//                    }
                }

            }
        }

        System.out.println(result);
    }
}
