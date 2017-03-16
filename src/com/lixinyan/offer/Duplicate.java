package com.lixinyan.offer;

/**
 * Created by Administrator on 2017/2/17.
 *
 */
public class Duplicate {
    public boolean duplicate(int numbers[],int length, int [] duplication) {
        if(numbers == null || length < 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length) return false;
        }

        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, numbers[i], i);
            }
        }

        return false;
    }

    public void swap(int[] x, int a, int b) {
        int t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
