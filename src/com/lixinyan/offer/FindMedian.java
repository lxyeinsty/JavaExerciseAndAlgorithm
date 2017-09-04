package com.lixinyan.offer;

/**
 * Created by lxy on 2017/6/21.
 *
 * 两个有序数组找中位数
 */
public class FindMedian {

    static int findMedium(int[] A, int[] B, int s, int t) {
        int c = (A.length + B.length - 1) / 2; //有多少个元素小于中位数
        int p = (s + t) / 2;

        /* 数组A中有p个数小于A[p], 当且进当数组B中有c-p个数小于A[p], Yuesefu[p]才是中位数 */
        if (A[p] >= B[c - p - 1] && A[p] <= B[c - p]) {
            return A[p];
        }

         /* Yuesefu[p]太小了，从数组A中找一个更大的数尝试 */
        if (A[p] < B[c - p - 1]) {
            return findMedium(A, B, p + 1, t);
        }

         /* Yuesefu[p]太大了，从数组A中找一个更小的数尝试 */
        return findMedium(A, B, s, p-1);
    }

    public static void main(String[] args) {
        int A[]={1,3,5,7,8,9,10,12,24,45,65};
        int B[]={2,4,6,10,11,12,13,14,17,19,20,34,44,45,66,99};

        System.out.println(findMedium(A, B, 0, A.length - 1));
    }
}
