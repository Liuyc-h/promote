package com.bj58.finance.platform.promote.algorithm.again;


import java.util.Deque;
import java.util.LinkedList;

/**
 *给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 * 通过次数523,117提交次数1,197,968
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution20 {

    public boolean isValid(String s){
        //特殊情况处理
        if(s == null || s.length() <= 1){
            return false;
        }
        //定义一个栈
        Deque<Character> deque = new LinkedList<>();
        for(int i = 0 ; i< s.length(); i++){
            //为空的话先push进去
            if(deque.isEmpty()){
                deque.push(s.charAt(i));
                continue;
            }
            if(isMatch(deque.peek(),s.charAt(i))){
                deque.pop();
                continue;
            }
            deque.push(s.charAt(i));
        }
        return deque.isEmpty() ? true : false;

    }

    private Boolean isMatch(char first,char second){

        if('(' == first && ')' == second){
            return true;
        }
        if('[' == first && ']' == second){
            return true;
        }
        if('{' == first && '}' == second){
            return true;
        }
        return false;

    }
}
