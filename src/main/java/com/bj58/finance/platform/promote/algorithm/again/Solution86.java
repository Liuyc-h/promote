package com.bj58.finance.platform.promote.algorithm.again;


import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/**
 *给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
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
 * **/
public class Solution86 {

    public ListNode partition(ListNode head, int x){
        if(head == null || head.next == null){
            return head;
        }
        //小的那一段
        ListNode smallNode = new ListNode(0);
        //大的那一段
        ListNode bigNode = new ListNode(0);

        ListNode flowSmall = smallNode;
        ListNode flowBig = bigNode;

        while(head != null){
            if(head.value < x){
                ListNode node = head;
                head = head.next;
                flowSmall.next = node;
                flowSmall = flowSmall.next;
                flowSmall.next = null;
            }else{
                ListNode node = head;
                head = head.next;
                flowBig.next = node;
                flowBig = flowBig.next;
                flowBig.next = null;
            }
        }
        flowSmall.next = bigNode.next;
        return smallNode.next;


    }
}
