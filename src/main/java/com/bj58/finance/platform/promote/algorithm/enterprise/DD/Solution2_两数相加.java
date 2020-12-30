package com.bj58.finance.platform.promote.algorithm.enterprise.DD;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/***
 *  给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 通过次数664,652提交次数1,696,468
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * ***/
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
        //溢出位
        int currFlag = 0;
        while(l1 != null || l2 != null){

            int value1 = l1 == null ? 0 : l1.value;
            int value2 = l2 == null ? 0 : l2.value;

            int currVal = value1 + value2 + currFlag;
            ListNode newNode = new ListNode(currVal % 10);
            currFlag = currVal / 10;
            flowNode.next = newNode;
            flowNode = flowNode.next;

            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        if(currFlag > 0){
            ListNode newNode = new ListNode(currFlag);
            flowNode.next = newNode;
        }
        return resultNode.next;
    }
}
