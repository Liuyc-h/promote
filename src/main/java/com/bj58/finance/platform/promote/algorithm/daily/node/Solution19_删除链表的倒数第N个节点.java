package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/**
 *给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution19_删除链表的倒数第N个节点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null){
            return head;
        }
        //先行node
        ListNode aheadNode = head;
        //后行node
        ListNode afterNode = head;

        for(int i =0; i< n -1; i++){
            aheadNode = aheadNode.next;
        }
        //如果aheadNode.next == null,证明此时删除的是头节点
        if(aheadNode.next == null){
            return afterNode.next;
        }
        aheadNode = aheadNode.next;
        while(aheadNode.next != null){
            aheadNode = aheadNode.next;
            afterNode = afterNode.next;
        }
        ListNode afterNextNext = afterNode.next.next;
        afterNode.next = afterNextNext;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.initListNode(new int[]{1,2});

        System.out.println(new Solution19_删除链表的倒数第N个节点().removeNthFromEnd(listNode,2));
    }
}
