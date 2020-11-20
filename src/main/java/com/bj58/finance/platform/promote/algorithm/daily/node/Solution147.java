package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

import java.util.List;

/**
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *  
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution147 {

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //结果node
        ListNode resultNode = new ListNode(0);
        //需要比较的节点数
        int count = 0;
        count ++;
        resultNode.next = head;
        //开始排序的起始节点
        ListNode startNode = head.next;
        resultNode.next.next = null;

        while(startNode != null){
            //需要比较的节点剥离出来
            ListNode compareNode = startNode;
            //指向下一个节点
            startNode = startNode.next;
            //已经比较过的复制一遍
            ListNode currResultNode = resultNode;
            //比较标志，
            Boolean compareFlag = false;
            //循环比较
            for(int i =0 ; i < count; i++){
                //搞出来一份
                ListNode currNode = currResultNode;
                //指向下一个节点
                currResultNode = currResultNode.next;
                if(currResultNode.value <= compareNode.value){
                    continue;
                }
                //比较过就跳出
                if(compareFlag){
                    break;
                }
                currNode.next = compareNode;
                compareNode.next = currResultNode;
                compareFlag = true;
            }
            if(!compareFlag){
                currResultNode.next = compareNode;
                currResultNode.next.next = null;
            }
            count ++;
        }
        return resultNode.next;
    }


    public ListNode insertionSortList1(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.value <= curr.value) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.value <= curr.value) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.initListNode(new int[]{-1,5,3,4,0});

        System.out.println(node);

        ListNode resultNode = new Solution147().insertionSortList1(node);

        System.out.println(resultNode);
    }
}
