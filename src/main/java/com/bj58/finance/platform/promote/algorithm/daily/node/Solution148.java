package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.daily.array.Solution134;
import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 *
 * ***/
public class Solution148 {

    public ListNode sortList(ListNode head) {

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.value - o2.value;
            }
        });

        while(head != null){
            priorityQueue.add(head);
            head = head.next;
        }
        ListNode resultNode = new ListNode(0);
        ListNode dealNode = resultNode;
        int length = priorityQueue.size();
        for(int i = 0; i< length - 1; i++){
            dealNode.next = priorityQueue.poll();
            dealNode = dealNode.next;
        }
        dealNode.next = priorityQueue.poll();
        dealNode.next.next = null;
        return resultNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.initListNode(new int[]{5,4,2,3,1});

        System.out.println(new Solution148().sortList(listNode));
    }
}
