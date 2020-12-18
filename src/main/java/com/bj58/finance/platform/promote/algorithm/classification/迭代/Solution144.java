package com.bj58.finance.platform.promote.algorithm.classification.迭代;

import com.alibaba.fastjson.JSONObject;
import com.bj58.finance.platform.promote.algorithm.struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *  二叉树得前序遍历
 * **/
public class Solution144 {

    /***
     *  根左右
     * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;

    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        dfs(root,res);
        return res;
    }
    //
    private void dfs(TreeNode treeNode,List<Integer> res){
        if(treeNode == null){
            return;
        }
        res.add(treeNode.val);
        dfs(treeNode.left,res);
        dfs(treeNode.right,res);
    }

//    public static void main(String[] args) {
//
//        TreeNode root = new TreeNode(0);
//
//        //第二层
//        TreeNode firstLeft = new TreeNode(1);
//        TreeNode firstRight = new TreeNode(1);
//        root.left = firstLeft;
//        root.right = firstRight;
//
//        //第三层
//        TreeNode secondLeftLeft = new TreeNode(2);
//        TreeNode secondLeftRight = new TreeNode(2);
//        firstLeft.left = secondLeftLeft;
//        firstLeft.right = secondLeftRight;
//        TreeNode secondRightLeft = new TreeNode(2);
//        TreeNode secondRightRight = new TreeNode(2);
//        firstRight.left = secondRightLeft;
//        firstRight.right = secondRightRight;
//
//        //第四层
//        TreeNode threeLeftLeftLeft = new TreeNode(3);
//        TreeNode threeLeftLeftRight = new TreeNode(3);
//        secondLeftLeft.left = threeLeftLeftLeft;
//        secondLeftLeft.right = threeLeftLeftRight;
//
//        TreeNode threeLeftRightLeft = new TreeNode(3);
//        TreeNode threeLeftRightRight = new TreeNode(3);
//        secondLeftRight.left = threeLeftRightLeft;
//        secondLeftRight.right = threeLeftRightRight;
//
//        TreeNode threeRightLeftLeft= new TreeNode(3);
//        TreeNode threeRightLeftRight = new TreeNode(3);
//        secondRightLeft.left = threeRightLeftLeft;
//        secondRightLeft.right = threeRightLeftRight;
//
//        TreeNode threeRightRightLeft= new TreeNode(3);
//        TreeNode threeRightRightRight = new TreeNode(3);
//        secondRightRight.left = threeRightRightLeft;
//        secondRightRight.right = threeRightRightRight;
//
//        System.out.println(new Solution144().preorderTraversal1(root));
//
//
//    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(JSONObject.toJSONString(new Solution144().preorderTraversal2(root)));
    }

    public List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> resultList = new ArrayList<>();

        if(root == null){
            return resultList;
        }
        //
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode flowNode = root;
        while(!deque.isEmpty() || flowNode != null){
            while(flowNode != null){
                resultList.add(flowNode.val);
                deque.push(flowNode);
                flowNode = flowNode.left;
            }
            TreeNode treeNode = deque.poll();
            flowNode = treeNode.right;
        }
        return resultList;
    }

}
