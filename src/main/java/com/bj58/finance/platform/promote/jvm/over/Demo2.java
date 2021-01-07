package com.bj58.finance.platform.promote.jvm.over;

public class Demo2 {

    static long counter = 0;
    public static void main(String[] args) {
        work();

    }

    public static void work(){
        counter ++;
        System.out.println(counter);
        System.out.println("jiayi");
        work();
    }
}
