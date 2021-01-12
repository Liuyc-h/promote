package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/**
 *  给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution2_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        //结果node
        ListNode resultNode = new ListNode(0);
        //状态流转node
        ListNode flowNode = resultNode;
        //两数相加是否溢出的标志
        int overInt = 0;

        while(l1 != null || l2 != null){

            int l1Vlaue = l1 == null ? 0 : l1.value;
            int l2Vlaue = l2 == null ? 0 : l2.value;

            int curr = l1Vlaue + l2Vlaue + overInt;

            ListNode newNode = new ListNode(curr % 10);
            overInt = curr / 10;
            flowNode.next = newNode;
            flowNode = flowNode.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(overInt > 0){
            flowNode.next = new ListNode(0);
        }
        return resultNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.initListNode(new int[]{2,4,3});
        ListNode l2 = ListNode.initListNode(new int[]{5,6,4});

        ListNode newNode = new Solution2_两数相加().addTwoNumbers(l1,l2);

        System.out.println(newNode);
    }
}
