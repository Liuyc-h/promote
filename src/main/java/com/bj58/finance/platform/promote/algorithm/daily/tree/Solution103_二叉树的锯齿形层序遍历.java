package com.bj58.finance.platform.promote.algorithm.daily.tree;

import com.alibaba.fastjson.JSONObject;
import com.bj58.finance.platform.promote.algorithm.struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * ***/
public class Solution103_二叉树的锯齿形层序遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //结果
        List<List<Integer>> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }
        //第一个栈
        Deque<TreeNode> deque1 = new LinkedList<>();
        //第二个栈
        Deque<TreeNode> deque2 = new LinkedList<>();
        //从左到右得标志
        boolean leftToRight = true;

        deque1.push(root);

        while(!deque1.isEmpty() || !deque2.isEmpty() ){

            List<Integer> result = new ArrayList<>();
            while(!deque1.isEmpty()){

                TreeNode node = deque1.pop();
                result.add(node.val);
                if(leftToRight){
                    if(node.left != null){
                        deque2.push(node.left);
                    }
                    if(node.right != null){
                        deque2.push(node.right);
                    }
                }else{
                    if(node.right != null){
                        deque2.push(node.right);
                    }
                    if(node.left != null){
                        deque2.push(node.left);
                    }
                }
            }
            leftToRight = !leftToRight;
            resultList.add(result);
            deque1 = deque2;
            deque2 = new LinkedList<>();
        }
        return resultList;
    }
    /**
     *  第一层从左到右
     *  第二层从右到左 先把左节点搞进去，在吧右节点搞过去
     *
     * **/
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        //结果List
        List<List<Integer>> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }
        //从左到右的遍历,利用栈的先进后出来做
        Boolean leftToRight = true;
        //第一个栈
        Deque<TreeNode> firstDeque = new LinkedList<>();
        //第二个栈
        Deque<TreeNode> secondDeque = new LinkedList<>();
        firstDeque.offer(root);
        //利用栈的先进后出来做
        while(!firstDeque.isEmpty() || !secondDeque.isEmpty()){
            List<Integer> result = new ArrayList<>();
            while(!firstDeque.isEmpty()){
                TreeNode treeNode = firstDeque.pop();
                result.add(treeNode.val);
                //如果本次是从左到右遍历的，下次应该是从右到左遍历，
                //则左边的先入栈，右节点后入栈
                if(leftToRight){
                    if(treeNode.left != null){
                        secondDeque.push(treeNode.left);
                    }
                    if(treeNode.right != null){
                        secondDeque.push(treeNode.right);
                    }
                }else{//如果本次是从右到左遍历的，下次应该是从左到右遍历
                    //则右节点先入栈，左节点后入栈
                    if(treeNode.right != null){
                        secondDeque.push(treeNode.right);
                    }
                    if(treeNode.left != null){
                        secondDeque.push(treeNode.left);
                    }
                }
            }
            //遍历结果入
            resultList.add(result);
            //将第二个栈付给第一个。下次遍历
            firstDeque = secondDeque;
            //第二个栈再重新赋值
            secondDeque = new LinkedList<>();
            //标志取反，下次遍历顺序反向
            leftToRight = !leftToRight;
        }
        return resultList;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(3);
        root.left = rootLeft;
        root.right = rootRight;

        TreeNode rootLeftLeft = new TreeNode(4);
        TreeNode rootRightRight = new TreeNode(5);
        rootLeft.left = rootLeftLeft;
        rootRight.right = rootRightRight;


        System.out.println(JSONObject.toJSONString(new Solution103_二叉树的锯齿形层序遍历().zigzagLevelOrder(root)));
    }
}
