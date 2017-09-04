package com.lixinyan.algorithm;

public class Test {
    public static void main(String[] args) {
        String str= "123456a";
        int i=Integer.parseInt(str);
    }


    class Super {
        int flag = 1;

        Super() {
            test();
        }

        void test() {
            System.out.println("Super.test() flag = "  + 10000000);
        }
    }

    class Sub extends Super {
        Sub(int i) {
            flag = i;
            System.out.println("Sub.SUb() flag=" + flag);
        }

        void test() {
            System.out.println("Sub.test flag=" + "eqe1weqweqw");
        }
    }

}

