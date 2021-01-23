package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/**
 *  请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * ***/
public class Solution234_回文链表 {

    public boolean isPalindrome(ListNode head) {
        //head为null得情况
        if(head == null){
            return true;
        }
        //先找出node节点得数量
        ListNode flowNode = head;
        int nodeCount = 0;
        while(flowNode != null){
            nodeCount = nodeCount + 1;
            flowNode = flowNode.next;
        }
        ListNode flowNode1 = head;
        for(int i = 0; i< nodeCount / 2; i++){
            flowNode1 = flowNode1.next;
        }
        if(nodeCount % 2 != 0){
            flowNode1 = flowNode1.next;
        }
        ListNode reverseNode = reverseNode(flowNode1);
        while(reverseNode != null){
            if(reverseNode.value != head.value){
                return false;
            }
            reverseNode = reverseNode.next;
            head = head.next;
        }
        return true;
    }
    /***
     *  翻转链表
     * */
    private ListNode reverseNode(ListNode head){

        ListNode resultNode = null;
        while(head != null ){
            ListNode node = head;
            head = head.next;
            node.next = resultNode;
            resultNode = node;
        }
        return resultNode;
    }


    public static void main(String[] args) {
        ListNode node = ListNode.initListNode(new int[]{1,2,3,4,5,4,3,2,1});

        System.out.println(new Solution234_回文链表().isPalindrome(node));
    }
}
