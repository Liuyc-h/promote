package com.bj58.finance.platform.promote.algorithm.again;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;


/**
 *  删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * ***/
public class Solution203 {

    public ListNode removeElements(ListNode head, int val){

        if(head == null ){
            return head;
        }
        //设立哑节点
        ListNode resultNode = new ListNode(0);

        ListNode flowNode = resultNode;
        while(head != null){
            if(head.value == val){
                head = head.next;
                continue;
            }
            ListNode node = head;
            head = head.next;
            flowNode.next = node;
            flowNode = flowNode.next;
            flowNode.next = null;
        }
        return resultNode.next;

    }
}
