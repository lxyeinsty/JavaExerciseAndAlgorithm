package com.lixinyan.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/2/12.
 *
 */
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> output = new ArrayList<>();
        if (input == null || k > input.length || k <= 0) {
            return output;
        }

        int start = 0;
        int n = input.length;
        int end = n - 1;

        int index = patition(input, n, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = patition(input, n, start, end);
            } else {
                start = index + 1;
                index = patition(input, n, start, end);
            }
        }

        for (int i = 0; i < k; i++) {
            output.add(input[i]);
        }

        return output;
    }

    public static int patition(int[] data, int lenth, int start, int end) {

        if (data == null || lenth <= 0 || start < 0 || end >= lenth) {
            //throw new InvalidAlgorithmParameterException();
        }

        int index = (int) Math.random() * (end - start) + start;
        swap(data, index, end);

        int small = start - 1;

        for (index = start; index < end; index++) {
            if (data[index] < data[end]) {
                ++ small;
                if (small != index) {
                    swap(data, index, small);
                }
            }
        }

        ++small;
        swap(data, small, end);

        return small;
    }

    public static void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //新建大顶堆
    public void buildMaxHeap(int[] arr,int lastIndex){
        for(int i = (lastIndex-1)/2;i>=0;i--){
            int k = i;
            while(2*k+1 <= lastIndex){
                int biggerIndex = 2*k+1;
                if(biggerIndex <lastIndex){
                    if(arr[biggerIndex]< arr[biggerIndex+1])
                        biggerIndex++;
                }
                if(arr[k] < arr[biggerIndex]){
                    swap(arr,k,biggerIndex);
                    k = biggerIndex;
                }
                else
                    break;
            }
        }
    }

    public void heapSort(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            buildMaxHeap(arr,arr.length-i-1);
            swap(arr,0,arr.length-i-1);
        }
    }
    public void getLeastNumbers(int[] arr,int k){
        if(arr == null || k<0 || k>arr.length)
            return;
        //根据输入数组前k个数简历最大堆
        //从k+1个数开始与根节点比较
        //大于根节点，舍去
        //小于，取代根节点，重建最大堆
        int[] kArray = Arrays.copyOfRange(arr, 0, k);
        heapSort(kArray);
        for(int i = k;i<arr.length;i++){
            if(arr[i]<kArray[k-1]){
                kArray[k-1] = arr[i];
                heapSort(kArray);
            }
        }
        for(int i:kArray)
            System.out.print(i);
    }
}
