package com.lixinyan.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/20.
 *
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (sum < 3) {
            return arrayLists;
        }

        int small = 1;
        int big = 2;
        int middle = (sum + 1) / 2;
        int curSum = small + big;

        while (small < middle) {
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                add(list,small,big);
                arrayLists.add(list);
            }

            while (curSum > sum && small < middle) {
                curSum = curSum - small;
                small++;

                if (curSum == sum) {
                    ArrayList<Integer> list = new ArrayList<>();
                    add(list,small,big);
                    arrayLists.add(list);
                }
            }

            big++;
            curSum = curSum + big;
        }

        return arrayLists;
    }

    public void add(ArrayList<Integer> list, int small, int big) {
        for (int i = small; i<=big; i++) {
            list.add(i);
        }
    }
}
