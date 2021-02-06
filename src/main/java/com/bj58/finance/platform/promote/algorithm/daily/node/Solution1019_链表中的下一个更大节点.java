package com.bj58.finance.platform.promote.algorithm.daily.node;

import com.alibaba.fastjson.JSONObject;
import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

import java.util.*;

/**
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 *
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 *
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * 示例 3：
 *
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 *  
 *
 * 提示：
 *
 * 对于链表中的每个节点，1 <= node.val <= 10^9
 * 给定列表的长度在 [0, 10000] 范围内
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-node-in-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution1019_链表中的下一个更大节点 {

    public int[] nextLargerNodes(ListNode head) {
        if(head == null ){
            return new int[0];
        }
        //存储索引位置和索引位置对应的node
        Map<Integer,ListNode> nodeMap = new HashMap<>();
        //节点个数
        int nodeCount = 0;
        //流转节点
        ListNode flowNode = head;
        while(flowNode != null){
            nodeCount ++;
            nodeMap.put(nodeCount,flowNode);
            flowNode = flowNode.next;
        }
        //结果数组
        int[] result = new int[nodeCount];
        //栈
        Deque<Integer> deque = new LinkedList<>();
        //索引计数
        int index = 1;
        //流转链表
        ListNode flowNode1 = head;
        while(flowNode1 != null){
            //为空的话先赋值
            if(deque.isEmpty()){
                deque.push(index++);
                flowNode1 = flowNode1.next;
                continue;
            }

            while(!deque.isEmpty() && nodeMap.get(deque.peek()).value < flowNode1.value){
                int resultIndex = deque.pop();
                result[resultIndex - 1] = flowNode1.value;
            }
            flowNode1 = flowNode1.next;
            deque.push(index ++);
        }
        return result;

    }

    public static void main(String[] args) {

        ListNode node = ListNode.initListNode(new int[]{8,8,7,1,6,6,9,8,10,5});

        System.out.println(JSONObject.toJSONString(new Solution1019_链表中的下一个更大节点().nextLargerNodes(node)));

    }
}
