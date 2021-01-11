package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/**
 *给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
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
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *  
 *
 * 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution24_两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode resultNode = new ListNode(0);
        ListNode flowNode = resultNode;
        while(head.next != null){
            //第一个节点
            ListNode firstNode = head;
            //第二个节点
            ListNode second = head.next;
            //下一次的起点
            head = head.next.next;
            //第二个元素放在第一位
            flowNode.next = second;
            flowNode = flowNode.next;
            //第一个元素
            firstNode.next = null;
            flowNode.next = firstNode;
            flowNode = flowNode.next;
            //如果head 为null,跳出循环
            if(head == null){
                break;
            }
        }
        if(head != null){
            flowNode.next = head;
        }
        return resultNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.initListNode(new int[]{1,2,3,4,5,6,7,8});

        ListNode resultNode = new Solution24_两两交换链表中的节点().swapPairs(listNode);
        System.out.println(resultNode);
    }
}
