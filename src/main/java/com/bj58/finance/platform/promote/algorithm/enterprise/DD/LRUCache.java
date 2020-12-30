package com.bj58.finance.platform.promote.algorithm.enterprise.DD;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 *
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class LRUCache {

    public class ListNode{
        int key;
        int value;
        ListNode next;
        ListNode prev;

        public ListNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer,ListNode> cacheMap;

    private int capacity ;

    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        head = null;
        tail = null;
    }

    public int get(int key) {
        //不存在返回-1
        if(!cacheMap.containsKey(key)){
            return -1;
        }
        ListNode currNode = cacheMap.get(key);
        removeToHead(currNode);
        return currNode.value;
    }

    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            ListNode currNode = cacheMap.get(key);
            currNode.value = value;
            removeToHead(currNode);
            return;
        }
        ListNode node = new ListNode(key,value);
        cacheMap.put(key,node);
        if(head == null){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
        if(cacheMap.size() > capacity){
            //取出尾节点的上一个节点
            ListNode prev = tail.prev;
            cacheMap.remove(tail.key);
            prev.next = null;
            tail = prev;
        }
    }
    /**
     *  移动node到头结点
     * **/
    private void removeToHead(ListNode currNode){
        //如果head为null。直接赋值就行
        if(head == null){
            head = currNode;
            tail = currNode;
            return;
        }
        //如果已经处在头结点，那就不用改了
        if(currNode == head){
            return;
        }
        //如果处在尾节点，移动到头结点
        if(currNode == tail){
            //取出尾节点的上一个节点
            ListNode prev = tail.prev;
            //prev的下个节点置为null
            prev.next = null;
            //tail的上一个节点置为null
            tail.prev = null;
            //tail下一个节点置为head
            tail.next = head;
            //head的上一个节点置为tail
            head.prev = tail;
            //重置tail和prev
            head = tail;
            tail = prev;
            return;
        }
        //如果处在头结点和尾节点中间
        ListNode prev = currNode.prev;
        ListNode next = currNode.next;
        prev.next = next;
        next.prev = prev;

        currNode.prev = null;
        currNode.next = head;
        head.prev = currNode;
        head = currNode;
    }
}
