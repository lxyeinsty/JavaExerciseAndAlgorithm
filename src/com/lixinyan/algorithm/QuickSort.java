package com.lixinyan.algorithm;

/**
 * Created by administrator on 2016/4/20.
 *
 */
public class QuickSort {

    public static void main (String[] args)  {
        int[] array = {25,15,27,99,18,35,14,66};
        final int a;
        System.out.println("Before Sort");
        ArrayUtils.printArray(array);

        quickSort(array);

        System.out.println("After Sort");
        ArrayUtils.printArray(array);
    }

    public static void quickSort(int[] array) {
        subQuickSort(array, 0, array.length - 1);
    }

    private static void subQuickSort(int[] array, int start, int end) {
        if (array == null && (end - start + 1) < 2) {
            return ;
        }

        int part = partition(array, start, end);
        if (part == start) {
            subQuickSort(array, part + 1, end);
        } else if (part == end) {
            subQuickSort(array, start, part - 1);
        } else {
            subQuickSort(array, start, part - 1);
            subQuickSort(array, part + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int value = array[end];
        int index = start - 1;

        for (int i = start; i < end; i++) {
            if (array[i] < value) {
                index++;
            }
            if (index != i) {
                ArrayUtils.exchangeElements(array, index, i);
            }
        }

        if ((index + 1) != end) {
            ArrayUtils.exchangeElements(array, index + 1, end);
        }

        return index + 1;
    }
}
