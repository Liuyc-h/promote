package com.bj58.finance.platform.promote.algorithm.again;


import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution61 {

    public ListNode rotateRight(ListNode head, int k){

        if(head == null || head.next == null || k == 0){
            return head;
        }
        //节点数量
        int nodeCount = 0;
        ListNode flowNode = head;
        while(flowNode != null){
            nodeCount ++;
            flowNode = flowNode.next;
        }
        //实际量
        k = k % nodeCount;
        if( k == 0){
           return head;
        }
        //第二个流转链表
        ListNode flowNode1 = head;
        for(int i = 0; i < nodeCount - k - 1; i++){
            flowNode1 = flowNode1.next;
        }
        //下半部分链表
        ListNode resultNode = flowNode1.next;
        //断开链表
        flowNode1.next = null;

        ListNode flowResultNode = resultNode;
        while(flowResultNode.next != null){
            flowResultNode = flowResultNode.next;
        }
        flowResultNode.next = head;
        return resultNode;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.initListNode(new int[]{1,2});

        System.out.println(new Solution61().rotateRight(node,2));
    }
}
