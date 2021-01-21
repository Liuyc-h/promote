package com.bj58.finance.platform.promote.jvm.demo;


/***
 *   gc参数
 *   -XX:NewSize=5242880 -XX:MaxNewSize=5242880
 *   -XX:InitialHeapSize=10485760 -XX:MaxHeapSize=10485760
 *   -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC
 *   -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 *   young gc
 * ***/
public class Demo1 {

//    public static void main(String[] args) {
//        byte[] array = new byte[1024 * 1024];
//
//        array = new byte[1024 * 1024];
//
//        array = new byte[1024 * 1024];
//
//        array = null;
//
//        byte[] array2 = new byte[2 * 1024 * 1024];
//
//
//    }

    public static void main(String[] args) {
        int i = 16;

        System.out.println(1<<i);
    }
}
