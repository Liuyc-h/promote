package com.bj58.finance.platform.promote.algorithm.daily.tree;

import com.bj58.finance.platform.promote.algorithm.struct.TreeNode;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [0]
 * 输出：[0]
 *  
 *
 * 提示：
 *
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 *  
 *
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution114_二叉树展开为链表 {


    public void flatten(TreeNode root) {

        if(root == null){
            return ;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;

        TreeNode right = root.right;

        root.left = null;
        root.right = left;
        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(5);
        root.left = rootLeft;
        root.right = rootRight;

        TreeNode rootLeftLeft = new TreeNode(3);
        TreeNode rootLeftRight = new TreeNode(4);
        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;

//        TreeNode rootRightLeft = new TreeNode(0);
        TreeNode rootRightRight = new TreeNode(6);
//        rootRight.left = rootRightLeft;
        rootRight.right = rootRightRight;

        TreeNode rootLeftRightLeft = new TreeNode(7);
        TreeNode rootLeftRightRight = new TreeNode(8);
        rootLeftRight.left = rootLeftRightLeft;
        rootLeftRight.right = rootLeftRightRight;
        new Solution114_二叉树展开为链表().flatten(root);
        System.out.println(root);
    }
}
