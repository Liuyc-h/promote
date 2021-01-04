package com.bj58.finance.platform.promote.algorithm.enterprise.DD;


import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution23_合并K个升序链表 {
    /**
     *  分治法
     *  划分为n个小任务去做
     *
     * **/
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        int length = lists.length;

        return mergeCommon(0,length - 1,lists);

    }

    private ListNode mergeCommon(int start,int end,ListNode[] lists){

        if(start == end){
            return lists[start];
        }
        int middle = (end - start) /2 + start;
        ListNode left = mergeCommon(start,middle,lists);
        ListNode right = mergeCommon(middle + 1,end,lists);
        if(left == null || right == null){
            return mergeListNode(right,left);
        }
        if(left.value > right.value){
            return mergeListNode(right,left);
        }
        return mergeListNode(left,right);

    }

    /**
     *  合并两个有序链表
     * ***/
    private ListNode mergeListNode(ListNode first,ListNode second){
        if(first == null){
            return second ;
        }
        if(second == null){
            return first;
        }
        ListNode resultNode = first;

        while(second != null){

            if(first.next == null){
                first.next = second;
                return resultNode;
            }else if(first.next.value > second.value){

                ListNode node = second;
                second = second.next;

                ListNode firstNext = first.next;
                first.next = node;
                node.next = firstNext;
            }
            first = first.next;
        }
        return resultNode;
    }



}
