package com.lixinyan.offer;

import java.util.Scanner;

public class DD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());
        int[] array = toIntArray(line.split(" "));
        findKth(k, array, 0, array.length - 1);
    }

    private static int partition(int[] array, int low, int high) {
        int temp = array[low];
        int pt = array[low];
        while (low != high) {
            while (low < high && array[high] <= pt)
                high--;
            array[low] = array[high];

            while (low < high && array[low] >= pt)
                low++;
            array[high] = array[low];
        }

        array[low] = temp;
        return low;
    }

    public static void findKth(int k, int[] array, int low, int high) {
        int temp;
        temp = partition(array, low, high);
        if (temp == k - 1) {
            System.out.println(array[temp]);
        } else if (temp > k - 1) {
            findKth(k, array, low, temp - 1);
        }
        else {
            findKth(k, array, temp + 1, high);
        }

    }

    public static int[] toIntArray(String[] array) {
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = Integer.parseInt(array[i]);
        }

        return  arr;
    }
}