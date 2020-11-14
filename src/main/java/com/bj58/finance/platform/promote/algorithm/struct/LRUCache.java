package com.bj58.finance.platform.promote.algorithm.struct;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * O（1）的时间复杂度完成LRUCache
 *
 * **/
public class LRUCache {

    //双向链表 + hash
    class TwoWayListNode{
        //key
        int key;
        //value
        int value;
        //前驱节点
        TwoWayListNode pre;
        //后继节点
        TwoWayListNode next;

        public TwoWayListNode(int key,int value){
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }

    private Map<Integer,TwoWayListNode> cacheMap ;

    private int maxSize;
    //尾节点
    TwoWayListNode tail;
    //头结点
    TwoWayListNode head;

    public LRUCache(int capacity){
        maxSize = capacity;
        cacheMap = new HashMap<>();
        tail = null;
        head = null;
    }

    public int get(int key) {
        TwoWayListNode keyNode = cacheMap.get(key);
        if(keyNode == null){
            return -1;
        }
        return keyNode.value;
    }

    public void put(int key, int value) {
        //头结点为null，还没有元素
        if(head == null){
            TwoWayListNode node = new TwoWayListNode(key,value);
            tail = node;
            head = node;
            cacheMap.put(key,node);
            return;
        }
        //如果已包含key
        if(cacheMap.containsKey(key)){
            //定义一个新链表
            TwoWayListNode keyNode = cacheMap.get(key);
            keyNode.value = value;
            //不等于头结点的话，挪到头结点
            move2Head(keyNode);
            cacheMap.put(key,keyNode);
        }else{//不包含的话直接连在头结点即可
            TwoWayListNode keyNode = new TwoWayListNode(key, value);
            head.pre = keyNode;
            keyNode.next = head;
            head = keyNode;
            cacheMap.put(key,keyNode);
        }
        //判断size是否大于最大长度，大于的话移除tail节点
        if(cacheMap.size() > maxSize){
            removeTail();
        }
    }
    //移到头结点
    private void move2Head(TwoWayListNode currNode){
        //如果和头结点相等，不做转换
        if(currNode.key == head.key){
            return;
        }
        //当前节点等于尾节点
        if(currNode.key == tail.key){
            currNode.pre.next  = null;
            tail = currNode.pre;
            currNode.pre = null;
            currNode.next = head;
            head.pre = currNode;
            head = currNode;
            return;
        }
        //不在头结点，也不在尾节点
        //curr的先驱节点
        TwoWayListNode preKeyNode = currNode.pre;
        //curr的后继节点
        TwoWayListNode nextKeyNode = currNode.next;
        //将先驱节点的next置为后继节点
        preKeyNode.next = nextKeyNode;
        //将后继节点的先驱节点置为curr的先去借点
        nextKeyNode.pre = preKeyNode;
        //头结点的先驱节点置为curr
        head.pre = currNode;
        //curr的后继节点置为head
        currNode.next = head;
        //head置为curr
        head = currNode;
    }

    private void removeTail(){
        //移除元素
        cacheMap.remove(tail.key);
        //尾节点前驱节点
        TwoWayListNode tailPre = tail.pre;
        //尾节点前驱节点的后继置为null
        tailPre.next = null;
        //tail的前驱节点置为null
        tail.pre = null;
        //重置尾节点
        tail = tailPre;
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
