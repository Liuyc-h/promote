package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/***
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Solution328 {

    public ListNode oddEvenList(ListNode head) {
        //链表得元素个数小于等于2的时候就不用往下走了，直接返回原链表
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }

        //奇数索引下的node
        ListNode qNode = new ListNode(0);
        ListNode resultQNode = qNode;
        //偶数索引下的node
        ListNode oNode = new ListNode(0);

        ListNode resultNode = oNode;

        int i = -1;
        while(head != null){
            i++;
            ListNode node = head;
            head = head.next;
            if(i % 2 == 0){
                oNode.next = node;
                oNode = oNode.next;
                oNode.next = null;
            }else{
                qNode.next = node;
                qNode = qNode.next;
                qNode.next = null;
            }
        }
        oNode.next = resultQNode.next;
        return resultNode.next;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.initListNode(new int[]{1,2,3,4,5});

        ListNode resultNode = new Solution328().oddEvenList(node);

        System.out.println(resultNode);
    }
}
