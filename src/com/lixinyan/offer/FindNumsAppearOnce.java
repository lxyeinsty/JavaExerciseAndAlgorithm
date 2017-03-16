package com.lixinyan.offer;

/**
 * Created by Administrator on 2017/3/4.、
 *
 */
public class FindNumsAppearOnce {
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }

        int resultOR = 0;

        for (int i = 0; i < array.length; i++) {
            resultOR = resultOR ^ array[i];
        }

        int indexOf1 = findFirstBitIs1(resultOR);

        num1[0] = 0;
        num2[0] = 0;
        for (int j = 0; j < array.length; j++) {
            if (isBit(array[j], indexOf1)) {
                num1[0] = num1[0] ^ array[j];
            } else {
                num2[0] = num2[0] ^ array[j];
            }
        }


    }

    int findFirstBitIs1(int num) {
        int indexBit = 0;
        while ((num & 1) == 0)  {
            num = num >> 1;
            indexBit++;
        }

        return indexBit;
    }

    boolean isBit(int num, int indexBit) {
        num = num >> indexBit;
        if ((num & 1) == 0) {
            return false;
        }

        return true;
    }
}
