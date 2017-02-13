package com.lixinyan.offer;

/**
 * Created by Administrator on 2017/2/11.
 *
 */
public class MoreThanHalfNum {
    public int moreThanHalfNum_Solution(int [] array) {
        if (array.length < 1) {
            return 0;
        }

        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            }
            else if (array[i] == result) {
                times++;
            } else {
                times--;
            }
        }

        return result;
    }
}
