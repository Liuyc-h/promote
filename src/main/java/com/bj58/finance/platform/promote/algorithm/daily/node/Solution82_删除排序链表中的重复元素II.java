package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

import java.util.HashSet;
import java.util.Set;

/***
 *  给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * ***/
public class Solution82_删除排序链表中的重复元素II {
    /**
     *  先存储下重复元素，然后删除，需遍历两遍
     * **/
    public ListNode deleteDuplicates(ListNode head) {
        //特殊情况处理
        if(head == null || head.next == null){
            return head;
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> repeatSet = new HashSet<>();
        ListNode flowNode = head;
        while(flowNode != null){
            if(set.contains(flowNode.value)){
                repeatSet.add(flowNode.value);
            }else{
                set.add(flowNode.value);
            }
            flowNode = flowNode.next;
        }
        ListNode resultNode = new ListNode(0);
        ListNode resultFlowNode = resultNode;

        while(head != null){
            if(!repeatSet.contains(head.value)){
                ListNode node = head;
                head = head.next;
                resultFlowNode.next = node;
                resultFlowNode = resultFlowNode.next;
                resultFlowNode.next = null;
            }else{
                head = head.next;
            }
        }
        return resultNode.next;
    }

    /**
     *  记录出现的顺序
     * **/
    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //结果node
        ListNode resultNode = new ListNode(0);
        //结果链表的流转链表
        ListNode flowNode = resultNode;
        //遍历的流转节点
        ListNode flowNodeHead = head.next;
        //上一个未重复节点
        ListNode lastNotRepeatNode = head;
        //节点值出现的频率
        int count = 1;

        while(flowNodeHead != null){
            //当前节点的值
            int currNodeData = flowNodeHead.value;
            //上一个未重复节点的值
            int lastNodeData = lastNotRepeatNode.value;
            //如果相等，节点值出现的频率加一，节点流转到下一个节点
            if(currNodeData == lastNodeData ){
                count ++;
                flowNodeHead = flowNodeHead.next;
            }else if(count == 1){//不相等且等于1的情况下，表明此节点未重复，连接到结果节点后面
                flowNode.next = lastNotRepeatNode;
                lastNotRepeatNode = flowNodeHead;
                flowNodeHead = flowNodeHead.next;
                flowNode = flowNode.next;
                flowNode.next = null;
            }else{//count ！= 1的情况下，重置节点和节点值，不进行链接
                lastNotRepeatNode = flowNodeHead;
                flowNodeHead = flowNodeHead.next;
                count = 1;
            }
        }
        if(count == 1){
            flowNode.next = lastNotRepeatNode;
        }
        return resultNode.next;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.initListNode(new int[]{1,1,1,2,3});

        System.out.println(new Solution82_删除排序链表中的重复元素II().deleteDuplicates(node));
    }
}
