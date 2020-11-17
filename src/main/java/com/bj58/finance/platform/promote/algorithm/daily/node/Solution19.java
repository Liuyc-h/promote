package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution19 {
    /**
     *  快慢指针
     * **/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //n为0或者head为null，直接返回head
        if(n == 0 || head == null){
            return head;
        }
        //head.next == null n为1的情况，直接返回null
        if(head.next == null && n == 1){
            return null;
        }
        //先行指针
        ListNode quickNode = head;
        //后行指针
        ListNode slowNode = head;
        //输出结果
        ListNode resultNode = slowNode;

        for(int i =0; i < n - 1; i++){
            quickNode = quickNode.next;
        }
        //到链表尾了，这个时候返回头节点的下个节点即可
        if(quickNode.next == null){
            return resultNode.next;
        }
        //再往后走一步，因为上一次只走了n - 1步
        quickNode = quickNode.next;
        while(quickNode.next != null){
            quickNode = quickNode.next;
            slowNode = slowNode.next;
        }
        ListNode slowNext = slowNode.next;

        ListNode slowNextNext = slowNext.next;

        slowNode.next = slowNextNext;
        return resultNode;
    }


    public static void main(String[] args) {
        ListNode listNode = ListNode.initListNode(new int[]{1,2,3,4,5});

        System.out.println(new Solution19().removeNthFromEnd(listNode,4));
    }
}
