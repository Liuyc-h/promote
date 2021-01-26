package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/***
 *  反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * ***/
public class Solution92_反转链表II {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null){
            return head;
        }
        //结果节点
        ListNode resultNode = new ListNode(0);
        //结果流转节点
        ListNode flowResultNode = resultNode;
        //head flow节点
        ListNode flowHead = head;
        //
        ListNode reverseNodeFirst = null;
        //
        ListNode reverseNode = null;
        //计数器
        int count = 0;

        while(flowHead != null){
            count ++;
            if(count < m || count > n){
                ListNode node =  flowHead;
                flowHead = flowHead.next;
                //结果链表赋值
                flowResultNode.next = node;
                flowResultNode = flowResultNode.next;
                flowResultNode.next = null;
            }else{
                ListNode node = flowHead;
                flowHead = flowHead.next;

                node.next = reverseNode;
                reverseNode = node;
                reverseNodeFirst = reverseNodeFirst == null ?
                        reverseNode : reverseNodeFirst;
            }
            if(count == n){
                flowResultNode.next = reverseNode;
                flowResultNode = reverseNodeFirst;
            }
        }
        return resultNode.next;
    }

}
