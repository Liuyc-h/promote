package com.bj58.finance.platform.promote.algorithm.daily.String;

import com.bj58.finance.platform.promote.utils.Solution;

import java.util.Deque;
import java.util.LinkedList;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2120 👎 0
public class Solution20_有效得括号 {

    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }

        Deque<Character> deque = new LinkedList<>();
        int length = s.length();
        for(int i = 0; i< length; i++){
            if(deque.isEmpty()){
                deque.push(s.charAt(i));
                continue;
            }
            if(isValue(deque,s.charAt(i))){
                deque.pop();
            }else{
                deque.push(s.charAt(i));
            }
        }
        return deque.isEmpty() ? true : false;
    }
    //
    private Boolean isValue(Deque<Character> deque,char curr){
        //()[]{}
        if(curr == ')' && deque.peek() == '('){
            return true;
        }
        if(curr == ']' && deque.peek() == '['){
            return true;
        }
        if(curr == '}' && deque.peek() == '{'){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "([)]";

        System.out.println(new Solution20_有效得括号().isValid(s));
    }
}
