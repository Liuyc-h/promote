package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;


/**
 *  给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *  
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k){

        if(head == null || head.next == null){
            return head;
        }
        //定义一个前驱节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //当前运动的链表节点
        ListNode curr = dummy;
        //上一次反转后的链表节点
        ListNode pre = dummy;

        while(curr.next != null){
            //先往后走k步
            for(int i = 0 ; i< k ; i++){
                //如果为null，跳出
                if(curr == null){
                    break;
                }
                curr = curr.next;
            }
            //curr为null，就跳出外部循环
            if(curr == null){
                break;
            }
            //本次翻转的开始节点
            ListNode currStart = pre.next;
            //下次翻转开始的节点
            ListNode nextStart = curr.next;
            //curr.next置null，把本次需要翻转的链表单独摘出来
            curr.next = null;
            //翻转链表
            ListNode reverseNode = this.reverseNode(currStart);
            //pre链表赋值为反转后的链表
            pre.next = reverseNode;

            //下一次循环的链表设置
            currStart.next = nextStart;
            pre= currStart;
            curr = currStart;
        }
        return dummy.next;
    }

    /**
     *  翻转链表
     * **/
    private ListNode reverseNode(ListNode head){

        if(head == null || head.next == null){
            return head;
        }
        ListNode resultNode = null;
        while(head != null){

            ListNode node = head;

            head = head.next;
            node.next = resultNode;
            resultNode = node;
        }
        return resultNode;
    }

    public static void main(String[] args) {

        ListNode listNode = ListNode.initListNode(new int[]{1,2,3,4,5,6,7,8,9});

        ListNode resultNode = new Solution25().reverseKGroup(listNode,3);

        System.out.println(resultNode);
    }
}
