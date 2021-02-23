package com.bj58.finance.platform.promote.algorithm.again;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        //定义两个栈
        Deque<Integer> dequel1 = new LinkedList<>();
        Deque<Integer> dequel2 = new LinkedList<>();
        //流转链表
        ListNode flow1 = l1;
        ListNode flow2 = l2;
        //放值
        while(flow1 != null || flow2 != null){

            if(flow1 != null){
                dequel1.push(flow1.value);
                flow1 = flow1.next;
            }
            if(flow2 != null){
                dequel2.push(flow2.value);
                flow2 = flow2.next;
            }
        }
        //先定义一个哑节点
        ListNode resultNode = null;

        int overFlow = 0;
        while(!dequel1.isEmpty() || !dequel2.isEmpty()){

            int data1 = dequel1.isEmpty() ? 0 : dequel1.pop();
            int data2 = dequel2.isEmpty() ? 0 : dequel2.pop();
            int sum = data1 + data2 + overFlow;

            ListNode newNode = new ListNode(sum % 10);
            newNode.next = resultNode;
            resultNode = newNode;
            overFlow = sum / 10;
        }
        if(overFlow > 0){
            ListNode newNode = new ListNode(overFlow);
            newNode.next = resultNode;
            resultNode = newNode;
        }
        return resultNode;
    }

    public static void main(String[] args) {
        ListNode node1 = ListNode.initListNode(new int[]{7,2,4,3});

        ListNode node2 = ListNode.initListNode(new int[]{5,6,4});

        System.out.println(new Solution445().addTwoNumbers(node1,node2));
    }
}
