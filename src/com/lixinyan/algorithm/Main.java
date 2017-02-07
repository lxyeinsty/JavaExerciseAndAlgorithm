package com.lixinyan.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/12.
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer x = in.nextInt();
        Integer y = in.nextInt();

        System.out.print(reverse(reverse(x) + reverse(y)));
    }

    public static Integer reverse(Integer x) {
        List<Character> charactersA = new ArrayList<>();

        char[] a = new StringBuffer(x.toString()).reverse().toString().toCharArray();

        for (int i = 0; i < a.length; i++) {
            charactersA.add(a[i]);
        }

        for (int i = 0; i < charactersA.size(); i++) {
            if (charactersA.get(0) == '0' && charactersA.get(i) == '0') {
                charactersA.remove(i);
            }
        }

        Object[] arrayX = charactersA.toArray();
        StringBuffer sb = new StringBuffer("");

        for (Object s : arrayX) {
            sb.append(s);
        }

        Integer target = Integer.parseInt(sb.toString());

        return  target;
    }
}
