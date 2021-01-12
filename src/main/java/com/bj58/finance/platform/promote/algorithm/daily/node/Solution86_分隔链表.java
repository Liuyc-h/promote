package com.bj58.finance.platform.promote.algorithm.daily.node;

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
public class Solution86_分隔链表 {

    public ListNode partition(ListNode head, int x) {
        //特殊情况处理
        if(head == null || head.next == null){
            return head;
        }
        //小于x的节点
        ListNode smallNode = new ListNode(0);
        ListNode smallFlowNode = smallNode;
        //大于x的节点
        ListNode largeNode = new ListNode(0);
        ListNode largeFlowNode = largeNode;
        while(head != null){

            if(head.value < x){
                ListNode node = head;
                head = head.next;
                smallFlowNode.next = node;
                smallFlowNode = smallFlowNode.next;
                smallFlowNode.next = null;
            }else{
                ListNode node = head;
                head = head.next;
                largeFlowNode.next = node;
                largeFlowNode = largeFlowNode.next;
                largeFlowNode.next = null;
            }
        }
        smallFlowNode.next = largeNode.next;
        return smallNode.next;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.initListNode(new int[]{1,4,3,2,5,2});

        System.out.println(new Solution86_分隔链表().partition(node,3));
    }
}
