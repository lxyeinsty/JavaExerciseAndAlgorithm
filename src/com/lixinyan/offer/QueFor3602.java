package com.lixinyan.offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/25.
 *
 */
public class QueFor3602 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();

        int count = 0;
        String[] strings = allSubString(string);
        for (int i = 0; i < strings.length; i++) {
            if (judge(strings[i])) {
                count++;
            }
        }

        System.out.println(count);

    }

    public static String[] allSubString(String a) {
        char[] str = a.toCharArray();
        int len = (1 + a.length()) * a.length() / 2;
        int index = 0;
        String result[] = new String[len];
        for (int i = 0; i < a.length(); i++) {
            String temp = "";
            for (int j = i; j < a.length(); j++) {
                temp += str[j];
                result[index++] = temp;
            }
        }

        return result;
    }

    public static boolean judge(String s) {
        char[] str = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            if (!hashMap.containsKey(str[i])) {
                hashMap.put(str[i], 1);
            } else {
                int a = hashMap.get(str[i]);
                a++;
                hashMap.put(str[i], a);
            }
        }

        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}
