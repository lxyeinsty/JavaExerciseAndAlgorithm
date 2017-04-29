package com.lixinyan.offer;

import java.util.*;

/**
 * Created by Administrator on 2017/4/7.
 *
 */
public class HuaweiRW {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String[] strings = string.split("|");
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            String[] strings1 = strings[i].replace("[", "").replace("]", "").split("\\.");
            ArrayList<Integer> list = new ArrayList<>()  ;
            for (int j = 0; j < strings1.length; j++) {
                list.add(Integer.parseInt(strings1[j]));
            }
            lists.add(list);
        }

        String[] result = new String[100];
        int minStart = lists.get(0).get(2);
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).get(2) < minStart) {
                minStart = lists.get(i).get(2);
            }
        }

        Collections.sort(lists, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(2) - o2.get(2);
            }
        });

        List<List<Integer>> newLists = new ArrayList<>();
        newLists.addAll(lists);
        Collections.sort(newLists, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(2) - o2.get(2);
            }
        });
        for (int i = 0; i < lists.size(); i++) {
            int temp = lists.get(i).get(2);
            if (temp > 0) {
                result[0] = "0." + temp;
            }

            for (int j = i; j < lists.size(); j++) {

            }
        }
    }
}
