package com.bj58.finance.platform.promote.algorithm.again;

import com.bj58.finance.platform.promote.algorithm.struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * **/
public class Solution_145 {

    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }
        dfs(root,resultList);
        return resultList;
    }

    private void dfs(TreeNode root,List<Integer> resultList){
        if(root == null){
            return ;
        }
        dfs(root.left,resultList);
        dfs(root.right,resultList);
        resultList.add(root.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root){

        List<Integer> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode flowNode = root;

        TreeNode prev = null;
        while(!deque.isEmpty() || flowNode != null){

            while(flowNode != null){
                deque.push(flowNode);
                flowNode = flowNode.left;
            }
            flowNode = deque.pop();
            if (flowNode.right == null || flowNode.right == prev) {
                resultList.add(flowNode.val);
                prev = flowNode;
                flowNode = null;
            } else {
                deque.push(flowNode);
                flowNode = flowNode.right;
            }
        }
        return resultList;

    }
}
