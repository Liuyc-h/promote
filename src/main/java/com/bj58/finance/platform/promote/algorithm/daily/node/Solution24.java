package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution24 {

    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode curr = new ListNode(0);
        ListNode resultNode = curr;


        while(head != null){

            if(head.next == null){
                curr.next = head;
                break;
            }
            //当前节点
            ListNode node = head;
            //当前节点的下一个节点
            ListNode nextNode = head.next;

            head = head.next.next;

            nextNode.next = node;
            node.next = null;
            curr.next = nextNode;
            curr = curr.next.next;
        }
        return resultNode.next;
    }


    public static void main(String[] args) {
        ListNode listNode = ListNode.initListNode(new int[]{1,2,3,4,5,6,7,8});

        ListNode resultNode = new Solution24().swapPairs(listNode);
        System.out.println(resultNode);
    }

    public ListNode swapPairs2(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode curr = new ListNode(0);
        ListNode resultNode = curr;


        while(head != null){

            if(head.next == null){
                curr.next = head;
                break;
            }
            //当前节点
            ListNode node = head;
            //当前节点的下一个节点
            ListNode nextNode = head.next;

            head = head.next.next;

            nextNode.next = node;
            node.next = null;
            curr.next = nextNode;
            curr = curr.next.next;
        }
        return resultNode.next;
    }
}
