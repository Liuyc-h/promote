package com.bj58.finance.platform.promote.algorithm.again;

import com.bj58.finance.platform.promote.algorithm.struct.TreeNode;
import sun.awt.image.ImageWatched;

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
 * 返回其层序遍历结果：
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
 * ***/
public class Solution_102 {

    public List<List<Integer>> levelOrder(TreeNode root){
        //
        List<List<Integer>> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }
        //定义两个队列
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(root);

        while(!queue1.isEmpty()){

            List<Integer> result = new ArrayList<>();
            while(!queue1.isEmpty()){
                TreeNode node = queue1.poll();
                result.add(node.val);
                if(node.left != null){
                    queue2.offer(node.left);
                }
                if(node.right != null){
                    queue2.offer(node.right);
                }
            }
            queue1 = queue2;
            queue2 = new LinkedList<>();
            resultList.add(result);
        }
        return resultList;


    }


}
