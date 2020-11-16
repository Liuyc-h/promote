package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/**
 *  将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.value > l2.value){
            return mergeNode(l2,l1);
        }
        return mergeNode(l1,l2);
    }
    /**
     *  合并有序链表
     * **/
    private ListNode mergeNode(ListNode first,ListNode second){

        ListNode resultNode = first;
        while(second != null){

            if(first.next == null){
                first.next = second;
                return resultNode;
            }else if(first.next.value > second.value){
                //节点剥离
                ListNode node = second;
                second = second.next;
                node.next = null;

                ListNode firstNext= first.next;
                first.next = node;
                node.next = firstNext;
            }
            first = first.next;
        }
        return resultNode;
    }

    public static void main(String[] args) {

        ListNode l1 = ListNode.initListNode(new int[]{1,2,4});

        ListNode l2 = ListNode.initListNode(new int[]{1,3,4});

        System.out.println(new Solution21().mergeNode(l1,l2));


    }
}
