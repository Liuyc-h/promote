package com.bj58.finance.platform.promote.algorithm.daily.tree;

import com.bj58.finance.platform.promote.algorithm.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution102 {
    /**
     *  层序遍历
     * **/
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }
        //当前遍历队列
        Queue<TreeNode> currQueue = new LinkedList<>();
        //下一个队列
        Queue<TreeNode> nextQueue = new LinkedList<>();

        currQueue.offer(root);

        while(!currQueue.isEmpty()  || !nextQueue.isEmpty()){

            List<Integer> result = new ArrayList<>();
            while(!currQueue.isEmpty()){
                TreeNode node = currQueue.poll();
                result.add(node.val);
                if(node.left != null){
                    nextQueue.offer(node.left);
                }
                if(node.right != null){
                    nextQueue.offer(node.right);
                }
            }
            if(result.size() != 0){
                resultList.add(result);
            }
            currQueue = nextQueue;
            nextQueue = new LinkedList<>();
        }
        return resultList;
    }


    /**
     * 层序遍历
     **/
    public List<Integer> levelOrder1(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            resultList.add(treeNode.val);
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }
        return resultList;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);

        //第二层
        TreeNode firstLeft = new TreeNode(1);
        TreeNode firstRight = new TreeNode(1);
        root.left = firstLeft;
        root.right = firstRight;

        //第三层
        TreeNode secondLeftLeft = new TreeNode(2);
        TreeNode secondLeftRight = new TreeNode(2);
        firstLeft.left = secondLeftLeft;
        firstLeft.right = secondLeftRight;
        TreeNode secondRightLeft = new TreeNode(2);
        TreeNode secondRightRight = new TreeNode(2);
        firstRight.left = secondRightLeft;
        firstRight.right = secondRightRight;

        //第四层
        TreeNode threeLeftLeftLeft = new TreeNode(3);
        TreeNode threeLeftLeftRight = new TreeNode(3);
        secondLeftLeft.left = threeLeftLeftLeft;
        secondLeftLeft.right = threeLeftLeftRight;

        TreeNode threeLeftRightLeft = new TreeNode(3);
        TreeNode threeLeftRightRight = new TreeNode(3);
        secondLeftRight.left = threeLeftRightLeft;
        secondLeftRight.right = threeLeftRightRight;

        TreeNode threeRightLeftLeft = new TreeNode(3);
        TreeNode threeRightLeftRight = new TreeNode(3);
        secondRightLeft.left = threeRightLeftLeft;
        secondRightLeft.right = threeRightLeftRight;

        TreeNode threeRightRightLeft = new TreeNode(3);
        TreeNode threeRightRightRight = new TreeNode(3);
        secondRightRight.left = threeRightRightLeft;
        secondRightRight.right = threeRightRightRight;

        System.out.println(new Solution102().levelOrder(root));


    }
}
