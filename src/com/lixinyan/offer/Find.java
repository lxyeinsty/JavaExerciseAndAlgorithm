package com.lixinyan.offer;

/**
 * Created by Administrator on 2017/2/10.
 *
 */
public class Find {
    public boolean find(int target, int array[][]) {
        int rows = array.length;
        int colunms = array[0].length;

        if (rows > 0 && colunms > 0) {
            int row = 0;
            int column = colunms - 1;

            while (row < rows && column >= 0) {
                if (array[row][column] == target) {
                    return true;
                } else if (array[row][column] > target) {
                    column--;
                } else {
                    row++;
                }
            }
        }

        return false;
    }
}
