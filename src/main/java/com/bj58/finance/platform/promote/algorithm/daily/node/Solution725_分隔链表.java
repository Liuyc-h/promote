package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.alibaba.fastjson.JSONObject;
import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

/**
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 *
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 *
 * 返回一个符合上述规则的链表的列表。
 *
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 *
 * 示例 1：
 *
 * 输入:
 * root = [1, 2, 3], k = 5
 * 输出: [[1],[2],[3],[],[]]
 * 解释:
 * 输入输出各部分都应该是链表，而不是数组。
 * 例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
 * 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 * 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 * 示例 2：
 *
 * 输入:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释:
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
 *  
 *
 * 提示:
 *
 * root 的长度范围： [0, 1000].
 * 输入的每个节点的大小范围：[0, 999].
 * k 的取值范围： [1, 50].
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution725_分隔链表 {

    public ListNode[] splitListToParts(ListNode root, int k) {

        ListNode[] result = new ListNode[k];
        if(root == null || root.next == null){
            result[0] = root;
            return result;
        }
        //流转链表
        ListNode flowRoot = root;
        int nodeCount = 0;
        while(flowRoot != null){
            nodeCount ++;
            flowRoot = flowRoot.next;
        }
        //每个得长度
        int nodeLength = nodeCount / k;
        //需要加一得长度
        int noanc = nodeCount % k;
        if(nodeCount / k == 0){
            nodeLength = 1;
            noanc = 0;
        }
        //需要放入得节点
        ListNode preNode = root;
        ListNode flowNode = root;
        int index = 0;
        while(index < k){
            int i = 0;
            while(flowNode != null && i < nodeLength - 1){
                flowNode = flowNode.next;
                i++;
            }
            if(flowNode != null){
                ListNode next = flowNode.next;
                if(noanc > 0){
                   next = flowNode.next.next;
                   //断开链表
                   flowNode.next.next = null;
                   noanc --;
                }else{
                    flowNode.next = null;
                }
                result[index] = preNode;
                preNode = next;
                flowNode = next;
            }
            index ++;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.initListNode(new int[]{1,2,3,4,5,6,7});

        System.out.println(JSONObject.toJSONString(new Solution725_分隔链表().splitListToParts(node,3)));
    }

}
