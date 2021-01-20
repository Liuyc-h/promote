package com.bj58.finance.platform.promote.algorithm.daily.String;

/***
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *  
 *
 * 提示：
 *
 * 输入的字符串长度不会超过 1000 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution647_回文子串 {

    /**
     *  先找出中心点，然后向两边扩展，中心点为 单个字符和2个字符的
     *
     *
     * */
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int result = 0;
        int length = s.length();

        for(int i = 0; i < 2 * length - 1; i++){
            //定义两个指针，左右
            int left = i / 2;
            int right = i / 2 + i % 2;
            while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)){
                result ++;
                left --;
                right ++;
            }
        }
        return result;
    }
}
