package com.bj58.finance.platform.promote.utils;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null){
            return head;
        }
        //结果节点
        ListNode resultNode = new ListNode(0);
        //结果流转节点
        ListNode flowResultNode = resultNode;
        //head flow节点
        ListNode flowHead = head;
        //
        ListNode reverseNodeFirst = null;
        //
        ListNode reverseNode = null;
        //计数器
        int count = 0;

        while(flowHead != null){
            count ++;
            if(count < m || count > n){
                ListNode node =  flowHead;
                flowHead = flowHead.next;
                //结果链表赋值
                flowResultNode.next = node;
                flowResultNode = flowResultNode.next;
                flowResultNode.next = null;
            }else{
                ListNode node = flowHead;
                flowHead = flowHead.next;

                node.next = reverseNode;
                reverseNode = node;
                reverseNodeFirst = reverseNodeFirst == null ?
                        reverseNode : reverseNodeFirst;
            }
            if(count == n){
                flowResultNode.next = reverseNode;
                flowResultNode = reverseNodeFirst;
            }
        }
        return resultNode.next;
    }
    public static void main(String[] args) {
        ListNode node = ListNode.initListNode(new int[]{1,2,6,3,4,5,6});
        System.out.println(new Solution().reverseBetween(node,2,6));
    }
}
