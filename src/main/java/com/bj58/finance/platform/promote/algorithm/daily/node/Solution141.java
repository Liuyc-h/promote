package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/***
 *  给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 *  
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 *
 *
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution141 {

    public boolean hasCycle(ListNode head) {

        if(head == null || head.next == null){
            return false;
        }
        //快指针
        ListNode quickNode = head;
        //慢指针
        ListNode slowNode = head;
        while(quickNode != null && slowNode != null){

            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
            if(quickNode == null || slowNode ==null){
                return false;
            }
            if(quickNode == slowNode){
                return true;
            }
            if(quickNode.next == null){
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.initRingListNode(new int[]{3,2,0,-4},1);
        System.out.println(new Solution141().hasCycle(node));
    }
}
