package com.lixinyan.algorithm;

import java.util.*;

public class Count {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.replace('\'', ' ');//将'号用空格替换
        str = str.replace(',', ' ');//将逗号用空格替换
        str = str.replace('.', ' ');//将句号用空格替换

        String[] strings = str.split("\\s+");   // “\\s+”代表一个或多个空格，是正则表达式
//      String[] strings = str.split(" +"); // “ +”在我的机器上也能代表一个或多个空格

        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> list = new ArrayList<String>();//存储每个不重复的单词

        for(String s : strings){
            if(map.containsKey(s)){//如果map中已经包含该单词，则将其个数+1
                int x = map.get(s);
                x++;
                map.put(s, x);
            }else{  //如果map中没用包含该单词，代表该单词第一次出现，则将其放入map并将个数设置为1
                map.put(s, 1);
                list.add(s);//将其添加到list中，代表它是一个新出现的单词
            }
        }

        int max=0;//记录出现次数最多的那个单词的出现次数
        String maxString = null;//记录出现次数最多的那个单词的值
        /*
         * 从list中取出每个单词，在map中查找其出现次数
         * 并没有真正排序，而只是记录下出现次数最多的那个单词
         */
        for(String s : list){
            int x = map.get(s);
            if(x>max){
                maxString = s;
                max = x;
            }
        }

        System.out.println(maxString);
        System.out.print(max);
    }
}
