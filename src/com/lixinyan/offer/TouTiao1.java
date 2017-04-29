package com.lixinyan.offer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/30.
 *
 */
public class TouTiao1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        String[] string = in.nextLine().split(" ");
        int[] num = new int[string.length];
        for (int i = 0; i < string.length; i++) {
            num[i] = Integer.parseInt(string[i]);
        }


        ArrayList<HashMap<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            HashMap<Integer,Integer> hashMap = find(num, i);
            list.add(hashMap);
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            HashMap<Integer, Integer> hashMap1 = list.get(i);
            for (Map.Entry<Integer, Integer> entry : hashMap1.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getKey();
                    index = i;
                }
            }
        }

        HashMap<Integer, Integer> hashMap = list.get(index);
        int start = 0;
        int end = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            start = entry.getKey();
            end = start + entry.getValue();
        }

        System.out.println(start + " " + end);
    }

    public static HashMap<Integer, Integer> find(int[] num, int start) {
        HashMap<Integer, Integer> hashMap0 = new HashMap<>();
        int cur = 0;
        int length = 0;
        for (int i = start; i < num.length; i++) {
            if (num[i] >= num[i + 1]) {
                hashMap0.put(start, -1);
                return hashMap0;
            } else {
                if (i - start >= 2) {
                    if (num[i-1] > num[i] && num[i + 1] >= num[i]) {
                        length++;
                        hashMap0.put(start, length);
                        return hashMap0;
                    } else {
                        length++;
                    }
                }
                length++;
            }

        }
        return hashMap0;
    }
}
