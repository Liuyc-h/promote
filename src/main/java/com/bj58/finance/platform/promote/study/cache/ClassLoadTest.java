package com.bj58.finance.platform.promote.study.cache;

public class ClassLoadTest {


    private ClassLoadTest(){
        System.out.println(num);
        System.out.println(str);
    }

    public static int num = 1;
    public static String str = "five";

    public static ClassLoadTest test = new ClassLoadTest();

    public static ClassLoadTest getInstance(){
        return test;
    }
}
