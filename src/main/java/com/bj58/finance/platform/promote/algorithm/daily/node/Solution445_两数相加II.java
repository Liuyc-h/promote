package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution445_两数相加II {
    //不修改输入链表得情况下得,用栈得方式也能做
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        //存储两个链表得map
        Map<ListNode,ListNode> l1Map = new HashMap<>();
        Map<ListNode,ListNode> l2Map = new HashMap<>();

        //定义两个流转链表
        ListNode l1FlowNode = l1;
        ListNode l2FlowNode = l2;
        l1Map.put(l1,null);
        l2Map.put(l2,null);
        //找出两个尾节点
        ListNode l1Tail = null;
        ListNode l2Tail = null;
        //存储链表和链表得前驱元素得映射
        while(l1FlowNode != null || l2FlowNode != null){
            if(l1FlowNode != null){
                if(l1FlowNode.next != null){
                    ListNode node1 = l1FlowNode;
                    ListNode node2 = l1FlowNode.next;
                    l1Map.put(node2,node1);
                }else{
                    l1Tail = l1FlowNode;
                }
                l1FlowNode = l1FlowNode.next;
            }
            if(l2FlowNode != null){
                if(l2FlowNode.next != null){
                    ListNode node1 = l2FlowNode;
                    ListNode node2 = l2FlowNode.next;
                    l2Map.put(node2,node1);
                }else{
                    l2Tail = l2FlowNode;
                }
                l2FlowNode = l2FlowNode.next;
            }
        }
        //结果链表
        ListNode resultNode = null;
        int overFlow = 0;
        while(l1Tail != null || l2Tail != null){

            int l1Data = l1Tail == null ? 0 : l1Tail.value;
            int l2Data = l2Tail == null ? 0 : l2Tail.value;

            int currData = l1Data + l2Data + overFlow;
            overFlow = currData / 10;
            ListNode node = new ListNode(currData % 10);
            node.next = resultNode;
            resultNode = node;
            if(l1Tail != null){
                l1Tail = l1Map.get(l1Tail);
            }
            if(l2Tail != null){
                l2Tail = l2Map.get(l2Tail);
            }
        }
        if(overFlow > 0){
            ListNode node = new ListNode(overFlow);
            node.next = resultNode;
            resultNode = node;
        }
        return resultNode;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2){

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        //翻转链表
        ListNode l1Reverse = reverseNode(l1);
        ListNode l2Reverse = reverseNode(l2);

        //结果链表
        ListNode resultNode = null;
        int overFlow = 0;
        while(l1Reverse != null || l2Reverse != null){
            int l1Data = l1Reverse == null ? 0 : l1Reverse.value;
            int l2Data = l2Reverse == null ? 0 : l2Reverse.value;

            int currData = l1Data + l2Data + overFlow;
            overFlow = currData / 10;
            ListNode node = new ListNode(currData % 10);
            node.next = resultNode;
            resultNode = node;
            if(l2Reverse != null){
                l2Reverse = l2Reverse.next;
            }
            if(l1Reverse != null){
                l1Reverse = l1Reverse.next;
            }
        }
        if(overFlow > 0){
            ListNode node = new ListNode(overFlow);
            node.next = resultNode;
            resultNode = node;
        }
        return resultNode;
    }


    private ListNode reverseNode(ListNode head){

        ListNode resultNode = null;
        while(head != null){
            ListNode node = head;
            head = head.next;
            node.next = resultNode;
            resultNode = node;
        }
        return resultNode;
    }
}
