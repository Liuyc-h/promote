package com.bj58.finance.platform.promote.algorithm.daily.tree;

import com.bj58.finance.platform.promote.algorithm.struct.TreeNode;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

/***
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 示例 2：
 *
 * 输入：root = []
 * 输出：0
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 树中节点的数目范围是[0, 5 * 104]
 * 0 <= Node.val <= 5 * 104
 * 题目数据保证输入的树是 完全二叉树
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution222_完全二叉树的节点个数 {

    public int countNodes(TreeNode root) {

        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while(!queue.isEmpty()){

            TreeNode treeNode = queue.poll();
            result ++;
            if(treeNode.left != null){
                queue.offer(treeNode.left);
            }
            if(treeNode.right != null){
                queue.offer(treeNode.right);
            }
        }
        return result;

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
}
