package com.lixinyan.offer;


import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by asus on 2017/4/28.
 *
 */
public class RemoveRepeated {
    private static TreeSet<String> treeSet = new TreeSet<>(); //

    public static void remove(String string) {
        for (int i = 0; i < string.length(); i++) {
            treeSet.add("" + string.charAt(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        remove(string);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : treeSet) {
            stringBuilder.append(s);
        }

        System.out.println(stringBuilder);
    }
}
