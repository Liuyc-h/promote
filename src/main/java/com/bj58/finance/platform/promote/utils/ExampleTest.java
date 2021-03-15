package com.bj58.finance.platform.promote.utils;


import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

public class ExampleTest{


    public ListNode deteCycle(ListNode head){

        if(head == null || head.next == null){
            return null;
        }
        //
        ListNode quickNode = head;
        ListNode slowNode = head;

        while(true){
            if(quickNode == null || quickNode.next == null){
                return null;
            }
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
            if(quickNode == slowNode){
                break;
            }
        }
        //环得长度
        int circleLength = 1;
        ListNode flowNode = slowNode.next;

        while(flowNode != slowNode){
            flowNode = flowNode.next;
            circleLength ++;
        }

        ListNode firstNode = head;
        ListNode secondNode = head;
        for(int i = 0; i< circleLength; i++){
            firstNode = firstNode.next;
        }
        while(firstNode != secondNode){
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return secondNode;
    }

    public static void main(String[] args) {


        ListNode node = ListNode.initRingListNode(new int[]{1,2,3,4,5,6},2);
        System.out.println(node);
        System.out.println(new ExampleTest().deteCycle(node));


    }
}
