package com.bj58.finance.platform.promote.algorithm.daily.tree;

import com.bj58.finance.platform.promote.algorithm.struct.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * ***/
public class Solution199_二叉树的右视图 {

    public List<Integer> rightSideView(TreeNode root) {
        //定义一个结果List
        List<Integer> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }
        //首节点加进去
        List<TreeNode> currList = new ArrayList<>();
        currList.add(root);


        while(true){
            List<TreeNode> nextList = new ArrayList<>();
            resultList.add(currList.get(currList.size() - 1).val);
            for(TreeNode node : currList){

                if(node.left != null){
                    nextList.add(node.left);
                }
                if(node.right != null){
                    nextList.add(node.right);
                }
            }
            if(nextList.size() == 0){
                break;
            }
            currList = nextList;
        }
        return resultList;

    }
}
