package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/***
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution06_从尾到头打印链表 {

    public int[] reversePrint(ListNode head) {
        if(head == null){
            return new int[0];
        }
        int nodeCount = 0;
        Deque<Integer> deque = new LinkedList<>();
        while(head != null){
            nodeCount ++;
            deque.push(head.value);
            head = head.next;
        }
        int[] result = new int[nodeCount];
        int index = 0;
        while(!deque.isEmpty()){
            result[index ++] = deque.pop();
        }
        return result;
    }
}
