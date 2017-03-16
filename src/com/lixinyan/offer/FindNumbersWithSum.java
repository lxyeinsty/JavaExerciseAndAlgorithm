package com.lixinyan.offer;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/20.
 *
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 2) {
            return list;
        }

        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            } else if (array[i] + array[j] < sum) {
                i++;
            } else {
                j--;
            }
        }

        return  list;
    }
}
