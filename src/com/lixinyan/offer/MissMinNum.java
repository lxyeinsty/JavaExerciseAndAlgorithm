package com.lixinyan.offer;

/**
 * Created by  2017/5/21.
 *
 */
public class MissMinNum {
    //空间O（n）,时间O（n）
    public int missMinNum(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (A[i]>0&&A[i]<=n){
                res[A[i]-1]=1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (res[i]==0){
                return i+1;
            }
        }
        return n+1;
    }

    //空间O（1）,时间O（n）
    public int missMinNum2(int[] arr) {
        {
            int l = 0; //l表示已经从1到L已经出现（左边界），l的初值为0。

            int r = arr.length; //如果一个数字过大（不合法），就会被扔掉，用r表示这个右边界，r初始值为arr长度。

            int temp;

            while (l < r) {
                if (arr[l] == l + 1) {
                    l++;
                } else if (arr[l] > r || arr[l] <= l || arr[arr[l] - 1] == arr[l])//不合法
                {

                    arr[l] = arr[--r];

                } else//合法但是没有在理想的位置上
                {
                    temp = arr[l];
                    arr[l] = arr[arr[l] - 1];
                    arr[temp - 1] = temp;

                }
            }
            return l + 1;
        }
    }
}
