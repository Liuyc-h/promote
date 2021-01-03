package com.bj58.finance.platform.promote.algorithm.daily.array;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/**
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *  
 *
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class Solution86_分隔链表 {

    public ListNode partition(ListNode head, int x) {
        //小于x的链表
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        //大于等于x的链表
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            //小于x的坠在small链表后面即可
            if (head.value < x) {
                small.next = head;
                small = small.next;
            } else {//大于x的坠在large链表后面即可

                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }


}
