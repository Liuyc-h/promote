package com.bj58.finance.platform.promote.algorithm.daily.tree;

import com.bj58.finance.platform.promote.algorithm.struct.TreeNode;
import lombok.val;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/***
 *给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution236_二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        //主节点和p节点相等，或者p q节点相等，则直接返回p
        if(p.val == root.val || p.val == q.val){
            return p;
        }
        //主节点和q节点相等，或者p q节点相等，则直接返回q
        if(q.val == root.val || p.val == q.val){
            return q;
        }
        //利用map存储treeNode，和TreeNode所在的深度和TreeNode的上层节点的值
        Map<Integer,Integer> valueDepth = new HashMap<>();
        //key为节点值，value为本节点和父节点
        Map<Integer,TreeNode[]> valueNode = new HashMap<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        //节点深度
        int depth = 0;
        valueDepth.put(root.val,depth);
        //两者都被找到的话退出
        while(!queue1.isEmpty() || !queue2.isEmpty() ) {
            depth++;
            while(!queue1.isEmpty()){
                TreeNode node = queue1.poll();
                if (node.left != null) {
                    assignValue(node.left, node, depth, valueDepth, valueNode);
                    queue2.offer(node.left);
                }
                if (node.right != null) {
                    assignValue(node.right, node, depth, valueDepth, valueNode);
                    queue2.offer(node.right);
                }
            }
            queue1 = queue2;
            queue2 = new LinkedList<>();
        }
        //
        int pDepth = valueDepth.get(p.val);
        int qDepth = valueDepth.get(q.val);

        TreeNode minFatherNode = pDepth > qDepth ? p : q;
        //先遍历吧，太他么麻烦了
        for(int i = Math.max(pDepth,qDepth); i>Math.min(pDepth,qDepth);i--){
            if(pDepth > qDepth){
                minFatherNode = valueNode.get(minFatherNode.val)[1];
            }else{
                minFatherNode = valueNode.get(minFatherNode.val)[1];
            }
        }

        TreeNode FatherNode = pDepth > qDepth ? q : p;
        for(int i = Math.min(pDepth,qDepth);i >= 0; i--){

            int val = minFatherNode.val;
            int another = FatherNode.val;
            if(val == another){
                return minFatherNode;
            }
            FatherNode = valueNode.get(another)[1];
            minFatherNode = valueNode.get(val)[1];
        }
        return null;
    }

    private void assignValue(TreeNode curr, TreeNode last,int depth,Map<Integer,Integer> valueDepth,
                             Map<Integer,TreeNode[]> valueNode){

        TreeNode[] treeNodes = new TreeNode[2];
        treeNodes[0] = curr;
        treeNodes[1] = last;
        valueDepth.put(curr.val,depth);
        valueNode.put(curr.val,treeNodes);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);

        TreeNode rootLeft = new TreeNode(5);
        TreeNode rootRight = new TreeNode(1);
        root.left = rootLeft;
        root.right = rootRight;

        TreeNode rootLeftLeft = new TreeNode(6);
        TreeNode rootLeftRight = new TreeNode(2);
        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;

        TreeNode rootRightLeft = new TreeNode(0);
        TreeNode rootRightRight = new TreeNode(8);
        rootRight.left = rootRightLeft;
        rootRight.right = rootRightRight;

        TreeNode rootLeftRightLeft = new TreeNode(7);
        TreeNode rootLeftRightRight = new TreeNode(4);
        rootLeftRight.left = rootLeftRightLeft;
        rootLeftRight.right = rootLeftRightRight;

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);

        System.out.println(new Solution236_二叉树的最近公共祖先().lowestCommonAncestor(root,p,q).val);

    }


}
