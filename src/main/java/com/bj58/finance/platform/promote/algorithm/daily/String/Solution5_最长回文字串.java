package com.bj58.finance.platform.promote.algorithm.daily.String;


/***
 *给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * **/
public class Solution5_最长回文字串 {

    //中新扩展算法
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        //字符串长度
        int length = s.length();

        int startIndex = 0;
        int endIndex = 0;

        for(int i =0; i< 2 * length - 1; i++){

            int left = i / 2;
            int right = i / 2 + i % 2;

            while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)){

                if(endIndex - startIndex < right - left){
                    endIndex = right;
                    startIndex = left;
                }
                left --;
                right ++;
            }
        }
        return s.substring(startIndex,endIndex + 1);
    }

    public static void main(String[] args) {

        String s = "aba";

        System.out.println(new Solution5_最长回文字串().longestPalindrome(s));

    }


}
