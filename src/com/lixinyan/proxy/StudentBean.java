package com.lixinyan.proxy;

/**
 * Created by Administrator on 2016/11/2.
 *
 */
public class StudentBean implements Student {
    private String name = "q";

    public StudentBean(){}

    public StudentBean(String name){
        this.name = name;
    }

    public void print(){
        System.out.println("Hello World!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
