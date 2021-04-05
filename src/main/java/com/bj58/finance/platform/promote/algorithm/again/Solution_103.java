package com.bj58.finance.platform.promote.algorithm.again;


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
public class Solution_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        //结果List
        List<List<Integer>> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }
        //定义两个栈去做
        Deque<TreeNode> deque1 = new LinkedList<>();
        //
        Deque<TreeNode> deque2 = new LinkedList<>();

        deque1.push(root);
        //从左到右的遍历
        Boolean leftToRight = true;
        while(!deque1.isEmpty()){
            List<Integer> result = new ArrayList<>();
            while(!deque1.isEmpty()){
                //出栈
                TreeNode treeNode = deque1.pop();
                result.add(treeNode.val);
                if(leftToRight){
                    if(treeNode.left != null){
                        deque2.push(treeNode.left);
                    }
                    if(treeNode.right != null){
                        deque2.push(treeNode.right);
                    }
                }else{
                    if(treeNode.right != null){
                        deque2.push(treeNode.right);
                    }
                    if(treeNode.left != null){
                        deque2.push(treeNode.left);
                    }
                }

            }
            leftToRight = !leftToRight;
            deque1 = deque2;
            deque2 = new LinkedList<>();
            resultList.add(result);
        }
        return resultList;


    }
}
