package com.bj58.finance.platform.promote.algorithm.again;

import com.bj58.finance.platform.promote.algorithm.struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/***
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 示例 5：
 *
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        //结果List
        List<Integer> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }
        dfs(resultList,root);
        return resultList;
    }

    private void dfs(List<Integer> resultList,TreeNode root){
        if(root == null){
            return;
        }
        resultList.add(root.val);
        dfs(resultList,root.left);
        dfs(resultList,root.right);
    }

    /**
     *  根节点
     * **/
    public List<Integer> preorderTraversal1(TreeNode root){

        //结果List
        List<Integer> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }
        //
        Deque<TreeNode> deque = new LinkedList<>();
        //流转节点
        TreeNode flow = root;

        while(!deque.isEmpty() || flow != null){

            while(flow != null){
                resultList.add(flow.val);
                deque.push(flow);
                flow = flow.left;
            }

            flow = deque.poll();
            flow = flow.right;

        }
        return resultList;




    }
}
