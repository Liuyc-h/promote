package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/***
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution83_删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //上一个节点
        ListNode result = head;
        ListNode prev = result;
        //当前遍历节点
        ListNode curr = head.next;

        while(curr != null){
            if(curr.value != prev.value){
                curr = curr.next;
                prev = prev.next;
                continue;
            }
            curr = curr.next;
            prev.next = curr;
        }
        return result;
    }
}
