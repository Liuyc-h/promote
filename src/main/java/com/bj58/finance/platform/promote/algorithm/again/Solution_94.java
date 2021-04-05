package com.bj58.finance.platform.promote.algorithm.again;

import com.bj58.finance.platform.promote.algorithm.struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
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
 * 输出：[2,1]
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
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution_94 {

    //递归
    public List<Integer> inorderTraversal(TreeNode root){
        //结果List
        List<Integer> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }
        dfs(root,resultList);
        return resultList;
    }

    public void dfs(TreeNode root,List<Integer> resultList){
        if(root == null){
            return;
        }
        dfs(root.left, resultList);
        resultList.add(root.val);
        dfs(root.right,resultList);
    }


    public List<Integer> inorderTraversal1(TreeNode root){
        //结果List
        List<Integer> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }
        //定义一个队列
        Deque<TreeNode> deque = new LinkedList<>();

        TreeNode flowNode = root;

        while(!deque.isEmpty() || flowNode != null){

            while(flowNode != null){
                deque.push(flowNode);
                flowNode = flowNode.left;
            }
            TreeNode node = deque.pop();
            resultList.add(node.val);
            flowNode = node.right;
        }
        return resultList;

    }


    public static void main(String[] args) {

    }


}
