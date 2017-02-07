package com.lixinyan.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/21.
 *
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = in.nextLine();
        }

        String[] strings1 = {"EIGHT", "NINE", "ZERO", "ONE", "TWO", "THREE",
                                "FOUR", "FIVE", "SIX", "SEVEN"};

        List list = new ArrayList<>();
        List<List<Character>> characters = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list = Arrays.asList(strings[i].toCharArray());
            characters.add(list);
        }

        char[][] chars = new char[10][5];
        for (int i = 0; i < strings1.length; i++) {
            chars[i] = strings1[i].toCharArray();
        }

        int flag = 0;
        int flag1 = 0;
        for (int i = 0; i < characters.size(); i++) {
            for (int j = 0; j < chars.length; i++) {
                for (int k = 0; k < chars[j].length; k++) {
                    for (int m = 0; m < characters.get(i).size(); m++) {
                        if (chars[j][k] == characters.get(i).get(m)) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag != 1) {
                        break;
                    }
                }
                for (n = 0; n < chars[j].length; i++) {
                    char a = chars[j][n];
                    characters.remove(characters.get(i).indexOf(a));
                }
            }

        }
    }
}
