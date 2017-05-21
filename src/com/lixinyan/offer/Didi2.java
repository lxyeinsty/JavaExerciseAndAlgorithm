package com.lixinyan.offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by  on 2017/5/7.
 */
public class Didi2 {

    public static void main(String[] args) {
        HashMap<Character, String> hashMap = new HashMap<>();

        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");

        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String[] strings = string.split(" ");
        String string1 = in.nextLine();
        char[] chars = string1.toCharArray();
        String aimString = "";
        for (int i = 0; i < chars.length; i++) {
            aimString = aimString + hashMap.get(chars[i]);
        }

        HashMap<String, Integer> result = new HashMap<>();

        for (int i =0; i < strings.length; i++) {
            result.put(strings[i], lcs(strings[i], aimString));
        }

        String maxKey = "";
        Integer maxValue = 0;
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        System.out.println(maxKey);
    }


    public static int lcs(String str1, String str2) {
        int[][] c = new int[str1.length() + 1][str2.length() + 1];
        for (int row = 0; row <= str1.length(); row++) {
            c[row][0] = 0;
        }

        for (int column = 0; column < str2.length(); column++) {
            c[0][column] = 0;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                }
                else if (c[i][j - 1] > c[i - 1][j]) {
                    c[i][j] = c[i][j - 1];
                }
                else {
                    c[i][j] = c[i - 1][j];
                }
            }
        }

        return c[str1.length()][str2.length()];
    }
}
