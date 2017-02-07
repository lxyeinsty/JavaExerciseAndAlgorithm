package com.lixinyan.algorithm;

import java.io.*;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by administrator on 2016/6/25.
 *
 */
public class IPToNumOutput {
    public static void main(String[] args) throws IOException {
        //创建高效字符输出流对象，将读到的数据存放到指定文件中
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:\\test.txt"));
        //将数据写出到文件中
        bufferedWriter.write("61.54.231.245");
        bufferedWriter.newLine();
        bufferedWriter.write("61.54.231.9");
        bufferedWriter.newLine();
        bufferedWriter.write("61.54.231.246");
        bufferedWriter.newLine();
        bufferedWriter.write("61.54.231.48");
        bufferedWriter.newLine();
        bufferedWriter.write("61.53.231.249");
        bufferedWriter.close();
        //创建高效字符输入流
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\test.txt"));
        //创建一个双列集合存放数据
        TreeMap<Integer, String> map = new TreeMap<>();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            //如果读到的数据不为空，那么就将读到的数据以“.”进行切割，然后存放到一个字符串数组中
            String[] split = str.split("\\.");
            //将数组的每个元素转换成数字然后再将转换后的数字按照IP地址的进制依次乘以256，然后相加，最终得到一个数字类型的值
            int parseInt = Integer.parseInt(split[0]) * 256 * 256 * 256
                    + Integer.parseInt(split[1]) * 256 * 256
                    + Integer.parseInt(split[2]) * 256
                    + Integer.parseInt(split[3]);
            //将得到的这个数值和原来的字符串以键值对应关系存放到集合中
            map.put(parseInt, str);
        }
        //关流
        bufferedReader.close();
        //将集合中所有键存放到一个set集合中
        Set<Integer> keySet = map.keySet();
        for (Integer integer : keySet) {
            System.out.println(map.get(integer));
        }
    }

}
