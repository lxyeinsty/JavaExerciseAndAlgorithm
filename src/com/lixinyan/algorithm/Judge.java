package com.lixinyan.algorithm;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/20.
 *
 */
public class Judge {
    public static void main(String[] args) {
        char[][] array = new char[3][3];
        int flag = 1;
        int count = 0;

        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            array[i] = in.nextLine().toCharArray();
            count++;
        }

        for (int i = 0; i < 3; i++) {
            if (flag == 0) {
                break;
            }
            for (int j = 0; j < 3; j++) {
                if (array[i][j] == 'X') {
                    if (array[2-i][2-j] != 'X') {
                        flag = 0;
                        break;
                    } else {
                        flag = 1;
                    }
                }
            }
        }

        if (flag == 1) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }

//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(array[i][j]);
//            }
//        }
    }

}
