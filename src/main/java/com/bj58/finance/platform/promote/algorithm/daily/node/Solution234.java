package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/**
 *请判断一个链表是否为回文链表。
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
 * **/
public class Solution234 {

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        int nodeSize = 0;
        ListNode sizeNode = head;
        while(sizeNode != null){
            nodeSize ++;
            sizeNode = sizeNode.next;
        }
        boolean flag = false;
        if(nodeSize % 2 != 0){
            flag = true;
        }
        ListNode newNode = head;

        for(int i = 0; i < (nodeSize / 2); i++){
            newNode = newNode.next;
        }
        if(flag){
            newNode = newNode.next;
        }
        ListNode reverseSecondNode = reverseNode(newNode);
        while(reverseSecondNode != null){
            if(reverseSecondNode.value != head.value){
                return false;
            }
            reverseSecondNode = reverseSecondNode.next;
            head = head.next;
        }
        return true;
    }
    /**
     *  翻转链表
     * */
    private ListNode reverseNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode reverseNode = null;

        while(head != null){
            ListNode newNode = head;
            head = head.next;

            newNode.next = reverseNode;
            reverseNode = newNode;

        }
        return reverseNode;
    }
}
