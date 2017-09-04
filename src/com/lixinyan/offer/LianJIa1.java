package com.lixinyan.offer;

import java.util.*;

/**
 * Created by a on 2017/8/19.
 *
 */
public class LianJIa1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        String string = in.nextLine();
        String[] array = string.split(" ");
        int[] arr = toIntArray(array);
        int[] newarr = remove(arr);
        Arrays.sort(newarr);
        System.out.println(newarr.length);
        for (int i = 0; i < newarr.length; i++) {
            if(i == newarr.length - 1) {
                System.out.print(String.valueOf(newarr[i]));
            } else {
                System.out.print(String.valueOf(newarr[i]) + " ");
            }
        }
    }

    public static int[] toIntArray(String[] array) {
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = Integer.parseInt(array[i]);
        }

        return  arr;
    }

    public static int[] remove(int[] array){
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            if (!list.contains(i)) {
                list.add(i);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
