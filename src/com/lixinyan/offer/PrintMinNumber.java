package com.lixinyan.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Administrator on 2017/2/12.
 *
 */
public class PrintMinNumber {
    public String printMinNumber(int [] numbers) {
        int n;
        String s = "";
        ArrayList<Integer> list = new ArrayList<>();
        n = numbers.length;

        for(int i = 0; i < n; i++){
            list.add(numbers[i]);//将数组放入arrayList中
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });

        for (int j : list) {
            s = s + j;
        }

        return s;
    }
}
