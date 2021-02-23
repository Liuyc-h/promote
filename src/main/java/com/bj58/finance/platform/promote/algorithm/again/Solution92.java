package com.bj58.finance.platform.promote.algorithm.again;

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
public class Solution92 {

    public ListNode reverseBetween(ListNode head, int m, int n){

        if(head == null || head.next == null){
            return head;
        }
        //结果
        ListNode resultNode = new ListNode(0);
        //状态流转
        ListNode flowResultNode = resultNode;
        //流转链表
        ListNode flowHead = head;
        //
        ListNode reverseNode = null;
        //第一个翻转的节点
        ListNode reverseFirst  = null;
        //计数
        int count = 1;

        while(flowHead != null){
            //小于m的情况
            if(count < m){
                ListNode node = flowHead;
                count ++;
                flowHead = flowHead.next;
                flowResultNode.next = node;
                flowResultNode= flowResultNode.next;
                flowResultNode.next = null;
                continue;
            }

            if(count >= m && count <= n){
                ListNode node = flowHead;
                flowHead = flowHead.next;
                count ++;
                node.next = reverseNode;
                reverseNode = node;
                if(reverseFirst == null){
                    reverseFirst = node;
                }
            }
            if(count == n + 1){
                break;
            }
        }
        flowResultNode.next = reverseNode;
        reverseFirst.next = flowHead;
        return resultNode.next;
    }


    public static void main(String[] args) {

        ListNode node = ListNode.initListNode(new int[]{1,2});

        System.out.println(new Solution92().reverseBetween(node,2,2));

    }
}
