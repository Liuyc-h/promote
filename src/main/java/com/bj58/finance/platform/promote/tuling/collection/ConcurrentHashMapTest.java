package com.bj58.finance.platform.promote.tuling.collection;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;

/***
 *1、底层数据结构
 *    1.7 数组 + 链表   大哈希表里面 套了一堆小的哈希表Segment，Segment继承了ReentranLock
 *    1.8 数组 + 链表 + 红黑树
 *
 *
 *
 *
 * ***/
public class ConcurrentHashMapTest {

    public static void main(String[] args) {


        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();

        map.put("liuyc","liuyc``");

        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        list.add(1);

        ArrayList list1 = new ArrayList();

//        ForkJoinPool
//
//        list.get();
//
//        map.get()

    }
}
