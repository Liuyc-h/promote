package com.bj58.finance.platform.promote.utils;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class ExampleTest {


    public Boolean judge(ListNode head){

        if(head == null || head.next == null){
            return true;
        }

        ListNode flowNode = head;
        //节点得数量
        int nodeCount = 0;
        while(flowNode != null){
            nodeCount ++;
            flowNode = flowNode.next;
        }
        //后续需要前进得步数
        int step = nodeCount / 2;
        //流转节点
        ListNode flowNode1 = head;
        for(int i = 0; i < step - 1; i++){
            flowNode1 = flowNode1.next;
        }
        //后半部分得链表
        ListNode secondHalfNode = null;
        if(nodeCount % 2 == 0){
            secondHalfNode = flowNode1.next;
            flowNode1.next = null;
        }else{
            secondHalfNode = flowNode1.next.next;
            flowNode1.next.next = null;
        }

        ListNode secondReverseNode = reverseNode(secondHalfNode);

        while(secondReverseNode != null){

            if(secondReverseNode.value != head.value){
                return false;
            }
            secondReverseNode = secondHalfNode.next;
            head = head.next;
        }
        return true;
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




    public static void main(String[] args) {



    }
}
