package com.bj58.finance.platform.promote.algorithm.daily.String;


import java.util.Deque;
import java.util.LinkedList;

/***
 * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
 *
 * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 *
 * 它是一个空字符串，或者
 * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 * 它可以被写作 (A)，其中 A 是有效字符串。
 * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："())"
 * 输出：1
 * 示例 2：
 *
 * 输入："((("
 * 输出：3
 * 示例 3：
 *
 * 输入："()"
 * 输出：0
 * 示例 4：
 *
 * 输入："()))(("
 * 输出：4
 *  
 *
 * 提示：
 *
 * S.length <= 1000
 * S 只包含 '(' 和 ')' 字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * ***/
public class Solution921_使括号有效的最小添加 {


    public int minAddToMakeValid(String S) {

        if(S == null || S.length() <= 1){
            return S == null ? 0 : S.length();
        }

        Deque<Character> deque = new LinkedList<>();

        for(int i = 0; i < S.length(); i++){

            if(deque.isEmpty()){
                deque.push(S.charAt(i));
                continue;
            }
            if('(' == deque.peek() && ')' == S.charAt(i)){
                deque.pop();
            }
        }
        return deque.size();
    }
    //以左括号为基准
    public int minAddToMakeValid1(String S){

        if(S == null || S.length() <= 1){
            return S == null ? 0 : S.length();
        }

        int left = 0;
        int right = 0;

        for(int i = 0; i< S.length(); i++){

            if('(' == S.charAt(i)){
                left ++;
            }
            if(')' == S.charAt(i)){
                left --;
                if(left == -1){
                    left = 0;
                    right ++;
                }
            }

        }
        return left + right;


    }


    public static void main(String[] args) {
        String s = "())";

        System.out.println(new Solution921_使括号有效的最小添加().minAddToMakeValid1(s));
    }


}
