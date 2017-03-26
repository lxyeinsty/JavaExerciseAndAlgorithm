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
        int carNum = in.nextInt();
        int[] tx = new int[carNum];
        for (int i = 0; i < carNum; i++) {
            tx[i] = in.nextInt();
        }
        int[] ty = new int[carNum];
        for (int i = 0; i < carNum; i++) {
            ty[i] = in.nextInt();
        }

        int[][] p = new int[200][200];
        boolean[][] pb = new boolean[200][200];
        for (int j = 0; j < carNum; j++) {
            p[tx[j] + 100][ty[j] + 100] = 1;
        }


        int gx = in.nextInt() + 100;
        int gy = in.nextInt() + 100;

        int walkTime = in.nextInt();
        int taixTime = in.nextInt();


        ArrayList<Integer> list = new ArrayList<>();
        int time = 0;
        getMin(p, pb, 1000, 1000, list, time, walkTime, taixTime, gx, gy);

        if(list.size() == 0){
            System.out.println(0);
            System.out.println();
            return;
        }
        int index = 0;
        for (int i = 0; i < list.size() ; i++){
            Integer s = list.get(i);
            int min = list.get(0);
            int temp = s;
            if (min > temp) {
                min = temp;
                index = i;
            }
        }

        System.out.println(list.get(index));
    }

    public static ArrayList<Integer> getMin(int[][] p, boolean[][] pb,
                                           int x, int y, ArrayList<Integer> list,
                                           int time, int walkTime, int taixTime,
                                            int gx, int gy) {
        if (x == gx || y == gy) {
            list.add(time);
            return list;
        }

        if (x >= 0 && x < 200 && y >= 0 && y < 200 && !pb[x][y]
                ) {
            pb[x][y] = true;
            if (p[x][y] == 1) {
                time = time + taixTime;
            } else {
                time = time + walkTime;
            }
            getMin(p, pb, x + 1, y, list, time, walkTime, taixTime, gx, gy);
            getMin(p, pb, x, y + 1, list, time, walkTime, taixTime, gx, gy);
            getMin(p, pb, x - 1, y, list, time, walkTime, taixTime, gx, gy);
            getMin(p, pb, x, y - 1, list, time, walkTime, taixTime, gx, gy);
        }

        return list;
    }
}
