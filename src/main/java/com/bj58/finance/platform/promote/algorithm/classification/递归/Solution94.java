package com.bj58.finance.platform.promote.algorithm.classification.递归;

import com.alibaba.fastjson.JSONObject;
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution94 {
    /**
     *  中序遍历  左中右,用递归 的方法
     * **/
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();

        dfs(root,resultList);
        return resultList;
    }

    private void dfs(TreeNode treeNode,List<Integer> resultList){
        if(treeNode == null){
            return;
        }
        dfs(treeNode.left,resultList);
        resultList.add(treeNode.val);
        dfs(treeNode.right,resultList);
    }

    /**
     *  用迭代的方法来做，手动维护一个栈
     * **/
    public List<Integer> inorderTraversal1(TreeNode root){

        List<Integer> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }
        //维护一个栈
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode flowNode = root;
        //
        while(!deque.isEmpty() || flowNode != null){

            while(flowNode != null){
                deque.push(flowNode);
                flowNode= flowNode.left;
            }
            flowNode = deque.poll();
            resultList.add(flowNode.val);
            flowNode = flowNode.right;
        }
        return resultList;

    }



    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(JSONObject.toJSONString(new Solution94().inorderTraversal1(root)));
    }
}
