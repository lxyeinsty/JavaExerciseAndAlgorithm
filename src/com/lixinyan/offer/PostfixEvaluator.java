package com.lixinyan.offer;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Administrator on 2017/3/18.
 *
 */
public class PostfixEvaluator {

    private final static char ADD = '+';
    private final static char SUBTRACT = '-';
    private final static char MULTIPLY = '*';
    private final static char DIVIDE = '/';



    public static int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();
        int opt1, opt2, result = 0;
        char token;

        char[] chars = expression.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            token = chars[i];
            if (isOperator(String.valueOf(token))) {
                opt2 = stack.pop();
                opt1 = stack.pop();
                result = evaluateSingleOperator(token, opt1, opt2);
                stack.push(result);
            } else {
                stack.push(new Integer(Integer.parseInt(String.valueOf(token))));
            }
        }

        return result;

    }

    /**
     * 计算每一部分的表达式
     * @param operator 操作符
     * @param op1 中间变量，操作符左边
     * @param op2 中间变量，操作符左边
     * @return 中间结果
     */
    private static int evaluateSingleOperator(char operator, int op1, int op2) {
        // TODO Auto-generated method stub
        int result = 0;
        //分情况计算
        switch (operator) {
            case ADD:
                result=op1+op2;
                break;
            case SUBTRACT:
                result=op1-op2;
                break;
            case MULTIPLY:
                result=op1*op2;
                break;
            case DIVIDE:
                result=op1/op2;
                break;
        }
        return result;
    }

    /**
     * 判断是否为操作符
     * @param token 字符
     * @return
     */
    private static boolean isOperator(String token) {
        // TODO Auto-generated method stub
        return (token.equals("+") || token.equals("-") || token.equals("*")
                || token.equals("/"));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();

        System.out.print(evaluate(expression));
    }

}
