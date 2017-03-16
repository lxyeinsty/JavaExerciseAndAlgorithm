package com.lixinyan.offer;

/**
 * Created by Administrator on 2017/2/17.
 *
 */
public class ReOrderArray {
    public void reOrderArray(int [] array) {  //不保证顺序不变
        if (array == null || array.length <= 0) {
            return;
        }

        int begin = 0;
        int end = array.length - 1;

        while (begin < end) {
            while (begin < end && array[begin] % 2 != 0) {
                begin++;
            }

            while (begin < end && array[end] % 2 == 0) {
                end--;
            }

            if (begin < end) {
                int temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
            }
        }
    }

    public void reOrderArray2(int [] array) {
        for (int i = 0; i < array.length;i++)
        {
            for (int j = array.length - 1; j>i;j--)
            {
                if (array[j] % 2 == 1 && array[j - 1]%2 == 0) //前偶后奇交换
                {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }

    }
}
