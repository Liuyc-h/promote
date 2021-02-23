package com.bj58.finance.platform.promote.algorithm.again;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/***
 *  给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * ***/
public class Solution82 {

    public ListNode deleteDuplicates(ListNode head){

        if(head == null || head.next == null){
            return head;
        }
        //定义一个哑节点
        ListNode resultNode = new ListNode(0);
        //状态流转节点
        ListNode flowResultNOde = resultNode;
        //上一个开始计数的node
        ListNode lastStartCountNode = head;
        //该节点值得个数
        int count = 1;
        //流转链表
        ListNode flowNode = head.next;
        while(flowNode != null){
            //两个值相等，count + 1
            if(flowNode.value == lastStartCountNode.value){
               count ++;
               flowNode = flowNode.next;
               continue;
            }
            if(count == 1){
                flowResultNOde.next = lastStartCountNode;
                flowResultNOde = flowResultNOde.next;
            }
            //重新赋值上一个开始计数得node
            ListNode node = flowNode;
            lastStartCountNode = node;
            count = 1;
            flowNode = flowNode.next;
        }
        if(count == 1){
            flowResultNOde.next = lastStartCountNode;
            flowResultNOde.next.next = null;
        }else{
            flowResultNOde.next = null;
        }
        return resultNode.next;

    }

    public static void main(String[] args) {
        ListNode node = ListNode.initListNode(new int[]{1,2,3,3,4,4,5});

        System.out.println(new Solution82().deleteDuplicates(node));
    }
}
