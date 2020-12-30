package com.bj58.finance.platform.promote.algorithm.enterprise.DD;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/***
 *  反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution206_反转链表 {

    public ListNode reverseList(ListNode head) {

        ListNode resultNode = null;

        ListNode curr = head;
        while(curr != null){
            ListNode node = curr;
            curr = curr.next;

            node.next = resultNode;
            resultNode = node;
        }
        return resultNode;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.initListNode(new int[]{1,2,3,4,5});

        System.out.println(new Solution206_反转链表().reverseList(node));
    }
}
