package com.bj58.finance.platform.promote.algorithm.daily.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *   146
 * ***/
public class LRUCache {
    /***
     * 定以一个双向链表
     * **/
    class TwoWayListNode{
        //key值
        int key;
        //value值
        int value;
        //前一个节点
        TwoWayListNode prev;
        //下一个节点
        TwoWayListNode next;
        /**
         *  Construct
         * **/
        public TwoWayListNode(int key,int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    /**
     *  定义一个map存放从key -> node的映射
     * **/
    private static Map<Integer,TwoWayListNode> nodeMap;
    //头节点
    private TwoWayListNode head;
    //尾节点
    private TwoWayListNode tail;
    //容量
    private int capacity;
    /***
     *  LRU Construct
     * **/
    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        head = null;
        tail = null;
    }

    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return -1;
        }
        TwoWayListNode resultNode = nodeMap.get(key);
        removeToHead(resultNode);
        return resultNode.value;
    }

    public void put(int key, int value) {
        //如果已包含,更新value并移动到head
        if(nodeMap.containsKey(key)){
            //取出node
            TwoWayListNode node = nodeMap.get(key);
            node.value = value;
            removeToHead(node);
            return;
        }
        TwoWayListNode newNode = new TwoWayListNode(key, value);
        nodeMap.put(key,newNode);
        removeToHead(newNode);
        if(nodeMap.size() > capacity){
            removeTail();
        }
    }
    /**
     *  remove node to head
     * **/
    private void removeToHead(TwoWayListNode node){
        //head为null,直接设置头尾节点
        if(head == null){
           head = node;
           tail = node;
           return;
        }
        //如果等于头节点，不需要做操作
        if(node == head){
           return;
        }
        //等于尾节点，尾节点移到head
        if(node == tail){
            TwoWayListNode tailPrev = tail.prev;
            tailPrev.next = null;
            tail.prev = null;
            tail.next = head;
            head.prev = tail;
            head = tail;
            tail = tailPrev;
            return;
        }
        //该节点不是头节点，并且前驱节点和后继节点皆为空，则表示是新加节点
        if(node.prev == null && node.next == null){
            head.prev = node;
            node.next = head;
            head = node;
            return;
        }
        //已有的节点处于中间的情况
        TwoWayListNode nodePrev  = node.prev;
        TwoWayListNode nodeNext  = node.next;
        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
    }
    /***
     *  触发淘汰
     * **/
    private void removeTail(){
        //head为null则退出
        if(head == null){
            return;
        }
        //此时只有一个元素
        if(head == tail){
           nodeMap.remove(head.key);
           head = null;
           tail = null;
           return;
        }
        //此时只有两个元素
        if(head.next == tail){
           nodeMap.remove(tail.key);
           head.next = null;
           tail.prev = null;
           tail = head;
           return;
        }
        //删除尾节点
        TwoWayListNode prevNode = tail.prev;
        prevNode.next = null;
        tail.prev = null;
        nodeMap.remove(tail.key);
        tail = prevNode;
    }

    public static void main(String[] args) {

        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }
}
