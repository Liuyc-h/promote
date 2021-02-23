package com.bj58.finance.platform.promote.algorithm.again;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/***
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
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
 *
 *
 * **/
public class Solution143 {

    public void reorderList(ListNode head){

        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        //先计算有多少个节点
        ListNode flowNode = head;
        int nodeCount = 0;
        while(flowNode != null){
            nodeCount ++;
            flowNode = flowNode.next;
        }
        //需要先走的步数
        int steps = (nodeCount - 1) / 2;
        //先把前半段给截下来
        ListNode firstNode = head;
        ListNode flowFirstNode = head;
        for(int i= 0; i < steps; i++){
            flowFirstNode = flowFirstNode.next;
        }
        //截下后半段链表
        ListNode secondNode = null;
        if((nodeCount - 1) % 2 == 0){
            secondNode = flowFirstNode.next;
            flowFirstNode.next = null;
        }else{
            secondNode = flowFirstNode.next.next;
            flowFirstNode.next.next = null;
        }
        //翻转后半段链表
        ListNode reverseNode = reverseList(secondNode);
        ListNode resultNode = new ListNode(0);

        ListNode flowResultNode = resultNode;

        ListNode node = firstNode;
        firstNode = firstNode.next;
        flowResultNode.next = node;
        flowResultNode = flowResultNode.next;
        flowResultNode.next = null;

        while(reverseNode != null){

            ListNode node1 = reverseNode;
            reverseNode = reverseNode.next;

            ListNode node2 = firstNode;
            firstNode = firstNode.next;
            flowResultNode.next = node1;
            flowResultNode.next.next = node2;
            flowResultNode = flowResultNode.next.next;
            flowResultNode.next = null;
        }
        if(firstNode != null){
            flowResultNode.next = firstNode;
        }
        head = resultNode.next;

    }

    /**
     *  头插法
     * **/
    public ListNode reverseList(ListNode head) {

        ListNode resultNode = null;
        while(head != null){
            ListNode node = head;
            head = head.next;

            node.next = resultNode;
            resultNode = node;
        }
        return resultNode;
    }

    public static void main(String[] args) {

        ListNode node = ListNode.initListNode(new int[]{1,2,3,4,5});
        new Solution143().reorderList(node);
        System.out.println(node);

    }
}
