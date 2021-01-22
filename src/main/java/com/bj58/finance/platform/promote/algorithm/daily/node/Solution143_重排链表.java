package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution143_重排链表 {
    //重排链表
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }
        //定义一个flow链表
        ListNode flowNode = head;
        int count = 0;
        //先对链表进行翻转并进行计数
        while (flowNode != null) {
            count++;
            flowNode = flowNode.next;
        }
        //需要转换得次数
        int transCount = (count - 1) / 2;
        ListNode flowNode1 = head;
        for(int i = 0; i < transCount; i++){
            flowNode1 = flowNode1.next;
        }
        //下半段得节点
        ListNode halfNode = null;
        if((count - 1) % 2 == 0 ){
            halfNode = flowNode1.next;
            flowNode1.next = null;//断开链表
        }else{
            halfNode = flowNode1.next.next;
            flowNode1.next.next = null;//断开链表
        }
        //后半段得翻转链表
        ListNode reverseNode = reverseNode(halfNode);
        //流转链表3
        ListNode flowNode2 = head;
        for(int i = 0; i < transCount; i++){
            ListNode flowNext = flowNode2.next;

            ListNode node = reverseNode;
            reverseNode = reverseNode.next;
            flowNode2.next = node;
            node.next = flowNext;

            flowNode2 = flowNode2.next.next;
        }
        if((count - 1) % 2 == 0){
            flowNode2.next = null;
        }else {
            flowNode2.next.next = null;
        }
    }
    /**
     * 翻转链表
     * **/
    private ListNode reverseNode(ListNode head){

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
        ListNode listNode = ListNode.initListNode(new int[]{1, 2, 3, 4,5});

        new Solution143_重排链表().reorderList(listNode);

        System.out.println(listNode);
    }


}
