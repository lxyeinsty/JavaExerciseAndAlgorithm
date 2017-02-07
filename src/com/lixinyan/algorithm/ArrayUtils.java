package com.lixinyan.algorithm;

/**
 * Created by administrator on 2016/4/20.
 *
 */
public class ArrayUtils {

    public static void printArray(int[] array) {
        System.out.println("{");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static void exchangeElements(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
