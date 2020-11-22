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
        if(dealNode.next != null){
            dealNode.next.next = null;
        }

        return resultNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.initListNode(new int[]{5,4,2,3,1});

        System.out.println(new Solution148().sortList(listNode));
    }

    public ListNode sortList1(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.value <= temp2.value) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
