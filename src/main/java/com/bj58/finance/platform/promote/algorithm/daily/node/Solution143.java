package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

import java.util.List;

/**
 *  给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution143 {

    public void reorderList(ListNode head) {

        if(head == null || head.next == null){
            return;
        }
        ListNode node = head;
        //先找出长度
        int count = 0;
        while(node != null){
            count ++;
            node = node.next;
        }
        //长度是奇数的标志
        Boolean qFlag =  false;
        if(count % 2 != 0){
            qFlag = true;
        }
        //中间节点
        ListNode middleNode = null;
        //前半部分节点
        ListNode dummpy = new ListNode(0);
        ListNode testNode = dummpy;
        //后半部分节点
        ListNode secondNode = null;
        //定义一个用于遍历的节点
        ListNode listNode = head;
        //前半部分后后半部分节点分离
        int index = 1;
        while(index <= (count / 2)){
            testNode.next = listNode;
            listNode = listNode.next;
            testNode = testNode.next;
            testNode.next = null;
            index ++;
        }
        //获得中间节点
        if(qFlag){
            middleNode = listNode;
            listNode = listNode.next;
            middleNode.next = null;
        }
        //后半部分节点
        secondNode = listNode;
        //翻转后半部分节点
        ListNode reverseSecondNode = reverseNode(secondNode);
        //前半部分的节点
        ListNode firstNode = dummpy.next;
        //结果节点
        ListNode resultNode = new ListNode(0);
        ListNode linkNode = resultNode;

        while(firstNode != null){
            linkNode.next = firstNode;
            firstNode = firstNode.next;
            linkNode = linkNode.next;
            linkNode.next = reverseSecondNode;
            reverseSecondNode = reverseSecondNode.next;
            linkNode = linkNode.next;
            linkNode.next = null;
        }

        if(middleNode != null){
            linkNode.next = middleNode;
        }
        head = resultNode.next;
    }

    //翻转链表
    private ListNode reverseNode(ListNode head){

        ListNode reverseNode = null;

        while(head != null){

            ListNode newNode = head;
            head = head.next;

            newNode.next = reverseNode;
            reverseNode = newNode;
        }
        return reverseNode;

    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.initListNode(new int[]{1,2,3,4});

        new Solution143().reorderList(listNode);
    }
}
