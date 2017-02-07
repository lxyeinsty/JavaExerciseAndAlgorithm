package com.lixinyan.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);

        int[] source = new int[10000];
        int[] a = new int[9997];
        List<Integer> b = new ArrayList<>(3);
        StringBuffer str = new StringBuffer("");

        String string = in.nextLine();

        String[] s = string.split(",");

        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

        for (int i = 0; i < source.length; i++) {
            source[i] = i;
        }

        for (int i = 0; i < 10000; i++) {
            if (!inArray(i + 1, source)) {
                b.add(i+1);
            }
        }

        for (Integer d : b) {
            str = str.append(d.toString());
        }

        int e = Integer.parseInt(str.toString());

        int f = e % 7;

        System.out.print(f);
    }

    public static boolean inArray(int a, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (a == array[i]) {
                return true;
            }
        }

        return false;
}

}

