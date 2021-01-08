package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/**
 *  给你一个链表数组，每个链表都已经按升序排列。
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
public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {
        //特殊情况特殊处理
        if(lists == null || lists.length == 0){
            return null;
        }
        //数组长度
        int length = lists.length;

        return mergeCommonPart(lists,0,length - 1);
    }
    /**
     *  公共部分
     * **/
    private ListNode mergeCommonPart(ListNode[] lists,int start,int end){
        if(start == end){
            return lists[start];
        }else{
            int mid = (end - start) / 2 + start;
            ListNode lcpLeft = mergeCommonPart(lists, start, mid);
            ListNode lcpRight = mergeCommonPart(lists, mid + 1, end);
            if(lcpLeft == null || lcpRight == null){
                return merge(lcpRight,lcpLeft);
            }
            if(lcpLeft.value > lcpRight.value){
                return merge(lcpRight,lcpLeft);
            }
            return merge(lcpLeft, lcpRight);
        }
    }

    /**
     *  合并有序链表
     * ***/
    private ListNode merge(ListNode first,ListNode second){

        if(first == null){
            return second;
        }
        if(second == null){
            return first;
        }
        ListNode resultNode = first;

        while(second != null){

            if(first.next == null){
                first.next = second;
                return resultNode;
            }else if(first.next.value >= second.value){
                //先把节点独立出来
                ListNode newNode = second;
                //second指向下一个节点
                second = second.next;
                //first的下一个节点
                ListNode next = first.next;
                first.next = newNode;
                newNode.next = next;
            }
            first = first.next;
        }
        return resultNode;
    }

    public static void main(String[] args) {


        ListNode node1 = ListNode.initListNode(new int[]{1,3,5,7});
        ListNode node2 = ListNode.initListNode(new int[]{1,2,3,5,6});
        ListNode node3 = ListNode.initListNode(new int[]{2,5,7,9});

        ListNode[] array = new ListNode[2];

        System.out.println(new Solution23().mergeKLists(array));

    }

}
