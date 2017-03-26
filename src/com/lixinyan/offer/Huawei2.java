package com.lixinyan.offer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/24.
 *
 */
public class Huawei2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] p = {
                {0, 2, 10, 5, 3, 1000},
                {1000, 0, 12, 1000, 1000, 10},
                {1000, 1000, 0, 1000, 7, 1000},
                {2, 1000, 1000, 0, 2, 1000},
                {4, 1000, 1000, 1, 0, 1000},
                {3, 1000, 1, 1000, 2, 0}
        };

        while (sc.hasNext()) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (x == 5) {
                System.out.print("0");
                System.out.print("[5]");
                continue;
            }

            if (x == y) {
                System.out.print("1000");
                System.out.print("[]");
                continue;
            }

            if (y != 0) {
                for (int i = 0; i < 6; i++) {
                    if (i != y - 1) {
                        p[y - 1][i] = 1000;
                        p[i][y - 1] = 1000;
                    }
                }
            }

            boolean[][] pb = new boolean[6][6];
            ArrayList<String> list = new ArrayList<>();
            int time = 0;
            String path = "";
            getMin(p, pb, 4, x - 1, list, time, path);

            if(list.size() == 0){
                System.out.println("1000");
                System.out.println("[]");
                continue;
            }
            int index = 0;
            int min=1000;
            for (int i=0; i<list.size() ; i++){
                String s = list.get(i);
                String[] ss1 =s.split(" ");
                int temp = Integer.valueOf(ss1[0]);
                if(min>temp){
                    min = temp;
                    index = i;
                }
            }
            String s = list.get(index);
            String[] ss1 =s.split(" ");
            System.out.println(ss1[0]);
            System.out.println("[5"+ss1[1]+"]");
        }
    }

    public static ArrayList<String> getMin(int[][] p, boolean[][] pb,
                                           int x, int y, ArrayList<String> list,
                                           int time, String path) {
        if (x == y) {
            list.add(String.valueOf(time) + " " + path);
            return list;
        }

        for (int j = 0; j < 6; j++) {
            if (j == x || p[j][x] == 1000 || pb[x][j]) {
                continue;
            }

            pb[x][j] = true;
            path = path + ", " + (j + 1);
            time = time + p[x][j];
            getMin(p, pb, j, y, list, time, path);
        }

        return list;
    }

}
