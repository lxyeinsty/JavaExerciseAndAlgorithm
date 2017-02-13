package com.lixinyan.offer;

import java.util.Stack;

/**
 * Created by Administrator on 2017/2/10.
 *
 */
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int first = stack2.pop();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return first;
    }
}
