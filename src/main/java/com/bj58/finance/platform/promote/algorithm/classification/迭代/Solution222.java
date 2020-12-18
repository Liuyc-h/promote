package com.bj58.finance.platform.promote.algorithm.classification.迭代;

import com.bj58.finance.platform.promote.algorithm.struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution222 {
    //用栈的方式做前序遍历
    public int countNodes(TreeNode root) {

        Deque<TreeNode> deque = new LinkedList<>();

        int nodeConut = 0;
        TreeNode node = root;
        while(!deque.isEmpty() || node != null){

            while(node != null){
                nodeConut ++;
                deque.push(node);
                node = node.left;
            }
            node = deque.pop();
            node = node.right;
        }
        return nodeConut;
    }
    //递归
    public int countNodes1(TreeNode root) {
        return dfs(root,0);
    }

    private int dfs(TreeNode root,int count){

        if(root == null){
            return count;
        }
        count ++;
        count = dfs(root.left,count);
        count = dfs(root.right,count);

        return count;
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

        TreeNode threeRightLeftLeft= new TreeNode(3);
        TreeNode threeRightLeftRight = new TreeNode(3);
        secondRightLeft.left = threeRightLeftLeft;
        secondRightLeft.right = threeRightLeftRight;

        TreeNode threeRightRightLeft= new TreeNode(3);
        TreeNode threeRightRightRight = new TreeNode(3);
        secondRightRight.left = threeRightRightLeft;
        secondRightRight.right = threeRightRightRight;

        System.out.println(new Solution222().countNodes1(root));








    }
}
