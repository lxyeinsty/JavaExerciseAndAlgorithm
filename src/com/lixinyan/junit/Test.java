package com.lixinyan.junit;

/**
 * Created by administrator on 2016/6/23.
 *
 */
public class Test {
    private String string = "java";

    @org.junit.Test
    public void test() {
        System.out.println("hello world");
    }

    @org.junit.Test
    public void test2() {
        System.out.println("你好");
    }

    @org.junit.Test
    public void test3() {
        System.out.println(string);
    }
}
