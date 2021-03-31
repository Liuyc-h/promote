package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;
import org.apache.ibatis.annotations.Delete;

/**
 *  给你链表的头节点 head 和一个整数 k 。
 *
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * 输出：[7,9,6,6,8,7,3,0,9,5]
 * 示例 3：
 *
 * 输入：head = [1], k = 1
 * 输出：[1]
 * 示例 4：
 *
 * 输入：head = [1,2], k = 1
 * 输出：[2,1]
 * 示例 5：
 *
 * 输入：head = [1,2,3], k = 2
 * 输出：[1,2,3]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目是 n
 * 1 <= k <= n <= 105
 * 0 <= Node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * ***/
public class Solution1721_交换链表中的节点 {

    public ListNode swapNodes(ListNode head, int k) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode dummpy = new ListNode(0);
        dummpy.next = head;
        //先行指针
        ListNode fastDummpy = dummpy;
        //后行指针
        ListNode slowDummpy = dummpy;
        ListNode commopnDummpy = dummpy;
        ListNode firstNode = null;
        ListNode secondNode = null;
        for(int i = 0; i< k; i++){
            fastDummpy = fastDummpy.next;
            commopnDummpy = commopnDummpy.next;
        }
        firstNode =commopnDummpy;

        while(fastDummpy != null){
            fastDummpy = fastDummpy.next;
            slowDummpy = slowDummpy.next;
        }
        secondNode = slowDummpy;

        int temp = firstNode.value;
        firstNode.value = secondNode.value;
        secondNode.value = temp;
        return head;


    }


    public static void main(String[] args) {
        ListNode node = ListNode.initListNode(new int[]{1,2,3,4,5});

        System.out.println(new Solution1721_交换链表中的节点().swapNodes(node,2));
    }
}
