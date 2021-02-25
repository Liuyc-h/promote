package com.bj58.finance.platform.promote.algorithm.daily.tree;

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
public class Solution145_二叉树的后序遍历 {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }

        dfs(resultList,root);
        return resultList;
    }

    private void dfs(List<Integer> resultList,TreeNode root){
        if(root == null){
            return ;
        }
        dfs(resultList, root.left);
        dfs(resultList, root.right);
        resultList.add(root.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root){
        List<Integer> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }

        Deque<TreeNode> deque = new LinkedList<>();

        TreeNode flow = root;

        TreeNode prev = null;
        while(!deque.isEmpty() || flow != null){

            while(flow != null){
                deque.push(flow);
                flow = flow.left;
            }
            flow = deque.pop();
            if (flow.right == null || flow.right == prev) {
                resultList.add(flow.val);
                prev = flow;
                flow = null;
            } else {
                deque.push(flow);
                flow = flow.right;
            }
        }
        return resultList;
    }

}
