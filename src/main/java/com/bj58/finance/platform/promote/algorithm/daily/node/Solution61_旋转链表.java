package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

import javax.swing.*;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution61_旋转链表 {

    public ListNode rotateRight(ListNode head, int k) {
        //特殊处理
        if(head == null || head.next == null  ){
            return head;
        }
        //先对数组进行翻转并记录长度
        int length = 0;
        ListNode flowNode = head;
        while(flowNode != null){
            length = length + 1;
            flowNode = flowNode.next;
        }
        k = k % length;
        if( k == 0){
            return head;
        }
        //先翻转整个链表
        ListNode reverseNode = reverseNode(head);

        ListNode flowReverseNode = reverseNode;
        for(int i = 0; i< k - 1; i++){
            flowReverseNode = flowReverseNode.next;
        }
        //下半段的node
        ListNode nextHalfNode = flowReverseNode.next;
        flowReverseNode.next = null;//断开链表
        ListNode halfReverseNode = reverseNode(nextHalfNode);
        //再翻转一次上半段链表
        ListNode result = reverseNode(reverseNode);

        ListNode flowResultNode = result;
        while(flowResultNode.next != null){
            flowResultNode = flowResultNode.next;
        }
        flowResultNode.next = halfReverseNode;
        return result;
    }

    /***
     *  翻转链表
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

        ListNode node = ListNode.initListNode(new int[]{1,2,3,4,5});

        System.out.println(new Solution61_旋转链表().rotateRight1(node,2));
    }

    /***
     *  找到断开点
     *
     * ***/
    public ListNode rotateRight1(ListNode head, int k){

        //特殊处理
        if(head == null || head.next == null  ){
            return head;
        }
        //先对数组进行翻转并记录长度
        int length = 0;
        ListNode flowNode = head;
        while(flowNode != null){
            length = length + 1;
            flowNode = flowNode.next;
        }
        k = k % length;
        if( k == 0){
            return head;
        }
        //定义两个指针
        ListNode quickNode = head;
        ListNode slowNode = head;
        for(int i = 0; i< k; i++){
            quickNode = quickNode.next;
        }
        while(quickNode.next != null){
            quickNode = quickNode.next;
            slowNode = slowNode.next;
        }
        ListNode halfNode = slowNode.next;
        slowNode.next = null;

        ListNode flowResultNode = halfNode;
        while(flowResultNode.next != null){
            flowResultNode = flowResultNode.next;
        }
        flowResultNode.next =  head;
        return halfNode;
    }
}
