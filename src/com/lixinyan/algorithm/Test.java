package com.lixinyan.algorithm;

import com.sun.xml.internal.ws.server.ServerRtException;

import java.io.*;
import java.math.BigDecimal;

import java.util.*;
import java.util.Comparator.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Test implements Serializable {
    public static void main(String[] args) throws Exception{
        Thread thread  = new Thread(() -> pong("pong"));

        thread.start();
        int[] a = new int[10];
        System.out.println("ping");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("dada"));
        objectOutputStream.writeObject(new Test());

        StringBuilder[] array = new StringBuilder[]{new StringBuilder("li")};
        StringBuilder[] copy = Arrays.copyOf(array, array.length);
        array[0].append("dede");
        System.out.println(Arrays.toString(copy));


//        List<String>[] listArray = new List[1];
//        List<String> list1 = new ArrayList<>();
//        list1.add("1");
//        listArray[0] = list1;
//        List<String>[] listArray1 = Arrays.copyOf(listArray, listArray.length);
//        list1.add("2");
//        System.out.println(listArray1[0]);
//
//
//
//        List<String> list = new ArrayList<>(Arrays.asList(array));
//        String[] arrays = list.toArray(new String[list.size()]);
//        list.add("1");
//        System.out.println(Arrays.toString(arrays));
//        Arrays.sort(array, String::compareTo);
//        System.out.println(Arrays.toString(array));
//
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("s", 1);
//
//        Set<Map.Entry<String, Object>> set = map.entrySet();
//        System.out.println(set);
//        map.put("a", 100);
//        System.out.println(set);
//        System.out.println(map);
//        List<Integer> lists = new ArrayList<>();
//        lists.add(1);
//        lists.add(2);
//        lists.forEach(System.out::println);
//        System.out.println(lists);
//
//        List<String> wordList = new ArrayList<>();
//        wordList.add("bdadhajkdhka");
//        wordList.add("he");
//        List<String> sub = wordList.subList(1,2);
//        wordList.add("ed");
//
//            System.out.println(sub);
//
//        List<String> output = wordList.stream().
//                map(String::toUpperCase).
//                collect(Collectors.toList());
//        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
//        System.out.println(output);
//        System.out.println(wordList);
    }

    public static void pong(String str) {
        System.out.println(str);
    }

}

