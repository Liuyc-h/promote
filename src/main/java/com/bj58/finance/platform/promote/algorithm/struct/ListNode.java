package com.bj58.finance.platform.promote.algorithm.struct;

import java.util.HashSet;
import java.util.Set;

/***
 *  链表
 * */
public class ListNode {

    public int value;

    public ListNode next;

    public ListNode(int value){
        this.value = value;
        next = null;
    }
    public ListNode(int value,ListNode next){
        this.value = value;
        this.next = next;
    }

    /*********************************   hash 方式确定环 start ***********************************/
    /**
     *  获取链表的环入口 hash
     * **/
    public static ListNode getLoopStartPointListNodeHash(ListNode listNode){
        Set<ListNode> nodeSet = new HashSet<>();

        ListNode curr = listNode;
        while(curr != null){

            if(nodeSet.contains(curr)){
                return curr;
            }
            nodeSet.add(curr);
            curr = curr.next;
        }
        return null;
    }

    /***
     *  获取环的长度 hash
     * */
    public static int getCircleLengthHash(ListNode listNode){
        //环形链表入口
        ListNode loopPointNode = getLoopStartPointListNodeHash(listNode);
        if(loopPointNode == null){
            return 0;
        }
        ListNode curr = loopPointNode.next;
        //环的长度
        int size = 0;
        while(curr != null){
            size = size + 1;
            if(curr == loopPointNode){
                return size;
            }
            curr = curr.next;
        }
        return size;
    }
    /*********************************   hash 方式确定环 end ***********************************/

    /*********************************   快慢指针 方式确定环 start***********************************/

    /**
     *  是否有环，快慢指针
     * */
    public static boolean isHavRing(ListNode listNode){

        if(listNode == null || listNode.next == null){
            return false;
        }
        //快指针
        ListNode quickNode = listNode;
        //慢指针
        ListNode slowNode = listNode;
        while(quickNode != null && slowNode != null ){

            if(quickNode.next == null){
                return false;
            }
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
            if(quickNode == null || slowNode == null){
                return false;
            }
            if(slowNode == quickNode){
                return true;
            }
        }
        return false;
    }

    /**
     *  获取环内的一个点
     * */
    private static ListNode getMeetingNode(ListNode listNode){
        if(listNode == null || listNode.next == null){
            return null;
        }
        //快指针
        ListNode quickNode = listNode;
        //慢指针
        ListNode slowNode = listNode;
        while(quickNode != null && slowNode != null ){

            if(quickNode.next == null){
                return null;
            }
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
            if(quickNode == null || slowNode == null){
                return null;
            }
            if(slowNode == quickNode){
                return slowNode;
            }
        }
        return null;
    }

    /**
     *  获取环的长度
     * */
    public static int getLoopNodeSizeSQ(ListNode listNode){
        //获取节点
        ListNode meetingNode = getMeetingNode(listNode);

        if(meetingNode == null){
            return 0;
        }
        int size = 0;
        ListNode currNode = meetingNode.next;
        while(currNode != null){
            size = size + 1;
            if(currNode ==meetingNode){
                return size;
            }
            currNode = currNode.next;
        }
        return size;
    }

    /***
     *  获取环的入口
     * */
    public static ListNode getCirCleStratNode(ListNode listNode){
        //环的长度
        int size = getLoopNodeSizeSQ(listNode);
        if(size == 0){
            return null;
        }
        ListNode curr = listNode;
        ListNode pre = listNode;

        for(int i = 0; i < size; i++){
            curr = curr.next;
        }

        while(curr != null && pre != null){

            if(curr == pre){
                return pre;
            }
            curr = curr.next;
            pre = pre.next;
        }
        return null;
    }

    /*********************************   快慢指针 方式确定环 end***********************************/

    /**
     *  初始构建带环node
     * @param array 数组
     * @param k 开始环的索引位置
     */
    public static ListNode initRingListNode(int[] array,int k){
        if(array == null){
            return null;
        }
        //头结点
        ListNode head = new ListNode(array[0]);

        ListNode curr = head;
        //环开始的节点
        ListNode cicleStartNode = null;
        if(k == 0){
            cicleStartNode = head;
        }
        for(int i = 1; i < array.length; i++){
            ListNode newNode = new ListNode(array[i]);
            if(k != 0 && i == k){
               cicleStartNode = newNode;
            }
            curr.next = newNode;
            curr = newNode;
        }
        curr.next = cicleStartNode;
        return head;
    }

    /**
     *  初始构建不带环node
     * @param array 数组
     */
    public static ListNode initListNode(int[] array){
        if(array == null){
            return null;
        }
        //头结点
        ListNode head = new ListNode(array[0]);

        ListNode curr = head;

        for(int i = 1; i < array.length; i++){
            ListNode newNode = new ListNode(array[i]);
            curr.next = newNode;
            curr = newNode;
        }
        return head;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        //获取链表
        ListNode circleNode = getLoopStartPointListNodeHash(this);
        if(circleNode == null){
            builder.append("该链表无环，head->");
        }else{
            builder.append("该链表有环,head->");
        }
        //定义一个转换链表
        ListNode curr = this;

        int freq = 0;
        while(curr != null){
            builder.append(curr.value);
            if(circleNode!= null && curr == circleNode){
                builder.append("(ring start point)");
                freq = freq + 1;
            }
            builder.append("->");
            curr = curr.next;
            if(freq == 2){
                break;
            }
        }
        if(circleNode == null){
            builder.append("null");
        }
        return builder.toString();
    }


    public static void main(String[] args) {

        int[] array = new int[]{1,2,3,4,5,6,7,8};

        ListNode listNode = initRingListNode(array,9);

        System.out.println(isHavRing(listNode));
        //环开始的
        ListNode meetingNode = getCirCleStratNode(listNode);
        //链表环的长度
        int size = getLoopNodeSizeSQ(listNode);
        if(meetingNode == null){
            System.out.println("链表无环");
        }else{
            System.out.println("链表有环，环处的值" + meetingNode.value + ",链表环的长度为" + size);
        }


        System.out.println(listNode);

    }
}
