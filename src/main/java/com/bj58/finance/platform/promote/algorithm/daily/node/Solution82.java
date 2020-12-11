package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
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
 * **/
public class Solution82 {
    /**
     *  先遍历一遍链表，查询出重复的值，放在Set集合里面，
     *  然后在遍历一次链表，找出重复的节点删除
     *  需要遍历两次链表
     * **/
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        Set<Integer> intSet = new HashSet<>();
        ListNode queryRepeatNode = head.next;
        int startVal = head.value;
        while(queryRepeatNode != null){
            //不相等的话流转一下
            if(startVal != queryRepeatNode.value){
                startVal = queryRepeatNode.value;
                queryRepeatNode = queryRepeatNode.next;
            }else{
                intSet.add(queryRepeatNode.value);
                queryRepeatNode = queryRepeatNode.next;
            }
        }
        ListNode resultNode = new ListNode(0);
        ListNode resultFlowNode = resultNode;
        ListNode flowNode = head;
        while(flowNode != null){
            int val = flowNode.value;
            if(!intSet.contains(val)){
                resultFlowNode.next = flowNode;
                flowNode = flowNode.next;
                resultFlowNode = resultFlowNode.next;
                resultFlowNode.next = null;
            }else{
                flowNode = flowNode.next;
            }
        }
        return resultNode.next;
    }

    /**
     *  记录节点和节点值的出现频率，
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
        ListNode node = ListNode.initListNode(new int[]{1,2,2});


        System.out.println(new Solution82().deleteDuplicates1(node));
    }
}
