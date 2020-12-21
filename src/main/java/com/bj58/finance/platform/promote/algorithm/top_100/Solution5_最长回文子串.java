package com.bj58.finance.platform.promote.algorithm.top_100;

/***
 *给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * **/
public class Solution5_最长回文子串 {

    /**
     * 用单个或者双个作为基值，然后向两边遍历
     *
     * **/
    public String longestPalindrome(String s){

        if(s == null || s.length() == 0){
            return "";
        }
        int length = s.length();
        //开始索引，定义一个巨大的数，到时候减成负的
        int startIndex = Integer.MAX_VALUE;
        int endIndex = 0;

        for(int i =0; i < 2 * length - 1; i++){
            //左边界
            int left = i / 2;
            //右边界
            int right = i / 2 + i % 2;
            while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)){

                if(right - left > endIndex - startIndex){
                    startIndex = left;
                    endIndex = right;
                }
                left --;
                right ++;
            }
        }
        return s.substring(startIndex,endIndex + 1);
    }
}
