package com.lixinyan.offer;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/29.
 *
 */
public class Wanmei1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strings = in.nextLine().split(",");
        int sum = in.nextInt();

        int[] num = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            num[i] = Integer.parseInt(strings[i]);
        }
        heapSort(num);

        int count = 0;


        count = getCount(num, sum, num.length - 1, count);

        System.out.println(count);

    }

    public static int getCount(int[] num, int sum, int i, int count) {
        int tempSum = sum;
        int temp = count;
        count = sum / num[i] + count;
        sum = sum % num[i];
        if (sum == 0) {
            return count;
        }
        else if (sum < num[0]) {
//            count = count - temp;
//            sum = tempSum;
//            count = getCount(num, sum, i - 1, count);
            return -1;
        }
        else {
            count = getCount(num, sum, i - 1, count);
        }

        return count;
    }

    public static void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

    public static void heapSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            createMaxdHeap(data, data.length - 1 - i);
            swap(data, 0, data.length - 1 - i);
        }
    }

    public static void createMaxdHeap(int[] data, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // 保存当前正在判断的节点
            int k = i;
            // 若当前节点的子节点存在
            while (2 * k + 1 <= lastIndex) {
                // biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点
                int biggerIndex = 2 * k + 1;
                if (biggerIndex < lastIndex) {
                    // 若右子节点存在，否则此时biggerIndex应该等于 lastIndex
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // 若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的值
                        biggerIndex++;
                    }
                }
                if (data[k] < data[biggerIndex]) {
                    // 若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k
                    swap(data, k, biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }
}
