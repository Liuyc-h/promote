package com.bj58.finance.platform.promote.algorithm.daily.node;


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
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class Solution2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        //看一下是否有进位，进位标志
        int currFlag = 0;
        //定义一个链表
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        //跳出循环的条件是两者都为空
        while(l1 != null && l2 != null){
            //l1的值
            int l1Value = l1 == null ? 0 : l1.value;
            //l2的值
            int l2value = l2 == null ? 0 : l2.value;

            int newValue = l1Value + l2value + currFlag;
            //对新值取余
            ListNode newNode = new ListNode(newValue % 10);
            //进位标志的值
            currFlag = newValue / 10;
            pre.next = newNode;
            pre = pre.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if( l2 != null){
                l2 = l2.next;
            }
        }
        if(currFlag > 0){
            ListNode newNode = new ListNode(currFlag);
            pre.next = newNode;
        }
        return curr.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.initListNode(new int[]{2,4,3});
        ListNode l2 = ListNode.initListNode(new int[]{5,6,4});

        ListNode newNode = new Solution2().addTwoNumbers(l1,l2);

        System.out.println(newNode);
    }
}
