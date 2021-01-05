package com.bj58.finance.platform.promote.jvm.demo;

/**
 * -XX:NewSize=10485760 -XX:MaxNewSize=10485760
 * -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520
 * -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC
 * -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc1.log
 *
 * **/
public class Demo2 {

    public static void main(String[] args) {
        //先分配2m
        byte[] array1 = new byte[2 * 1024 * 1024];
        //再分配2M
        array1 = new byte[2 * 1024 * 1024];
        //再分配2m
        array1 = new byte[2 * 1024 * 1024];
        //放弃引用
        array1 = null;
        //分配  128 k
        byte[] array2 = new byte[128 * 1024];
        //再分配2m，此时Eden区空间不足，进行young gc，剩下2.125M，不足，会进入老年代
        byte[] array3 = new byte[2 * 1024 * 1024];
    }
}
