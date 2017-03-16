package com.lixinyan.offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/2/18.
 *
 */
public class NumberFind {

    public static List findNumbers(int value, int[] array, int startPos) {
        List ret = new ArrayList<>();
        int arrayLen = array.length;
        if(startPos >= arrayLen) {
            //如果起始位置已经越界
            return ret;
        }
        //判断本数组内是否有该值？
        for(int i = startPos; i < arrayLen; ++i) {
            if(value == array[i]) {
                List values = new ArrayList();
                values.add(new Integer(array[i]));
                ret.add(values);
            }
        }

        //取出第一值，然后递归判断
        for(int i = startPos; i < arrayLen; ++i ) {
            int plusedValue = value - array[i];
            List numbersArray = findNumbers(plusedValue, array, i + 1);
            for(Iterator it = numbersArray.iterator(); it.hasNext(); ) {
                List numbers = (List)it.next();
                List values = new ArrayList();
                values.add(new Integer(array[i]));
                values.addAll(numbers);
                ret.add(values);
            }

        }
        return ret;
    }

    public static List findNumbers(int value, int[] array) {
        return findNumbers(value, array, 0);
    }

    public static void main(String[] args) {
        int array[] = {-10,45,35,99,10,6,9,20,17,18};
        List result = findNumbers(35, array);
        printResult(result);
    }

    private static void printResult(List result) {
        for(Iterator it = result.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}