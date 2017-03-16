package com.lixinyan.offer;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by Administrator on 2017/2/15.
 *
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }

        TreeSet<String> treeSet = new TreeSet<>();
        Permutation(str.toCharArray(), 0, treeSet);
        result.addAll(treeSet);
        return result;
    }

    public void Permutation(char[] chars, int begin, TreeSet<String> result) {
        if(chars==null || chars.length==0 || begin<0 || begin>chars.length-1) { return ; }

        if (begin == chars.length - 1) {
            result.add(String.valueOf(chars));
        }

        for (int i = begin; i< chars.length; i++) {
            swap(chars, i, begin);
            Permutation(chars, begin+ 1, result);
            swap(chars, begin, i);
        }
    }


    public void swap(char[] x, int a, int b) {
        char t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
