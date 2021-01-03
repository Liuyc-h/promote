package com.bj58.finance.platform.promote.algorithm.enterprise.DD;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/**
 *将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 通过次数437,630提交次数673,440
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * **/
public class Solution21_合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.value > l2.value){
            return merge(l2,l1);
        }
        return merge(l1,l2);
    }

    private ListNode merge(ListNode first,ListNode second){

        ListNode resultNode = first;

        while(second != null){

            if(first.next == null){
                first.next = second;
                return resultNode;
            }else if(first.next.value >= second.value){//
                ListNode newNode = second;
                second = second.next;

                ListNode next = first.next;
                first.next = newNode;
                newNode.next = next;
            }
            first = first.next;
        }
        return resultNode;

    }

    public static void main(String[] args) {

        ListNode first = ListNode.initListNode(new int[]{1,3,5});
        ListNode second = ListNode.initListNode(new int[]{2,4,6});

        System.out.println(new Solution21_合并两个有序链表().mergeTwoLists(first,second));
    }
}
