package com.lixinyan.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/21.
 *
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) {
            return res;
        }

        int begin;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            if (deque.isEmpty()) {
                deque.add(i);
            } else if (begin > deque.peekFirst()) {
                deque.pollFirst();
            }

            while ((!deque.isEmpty()) && num[i] >= num[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.add(i);
            if (begin >= 0) res.add(num[deque.peekFirst()]);
        }

        return res;
    }
}
