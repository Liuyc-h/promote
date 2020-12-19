package com.bj58.finance.platform.promote.algorithm.top_100;


import java.util.HashSet;
import java.util.Set;

/**
 *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution3_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s){

        if(s == null || s.length() <= 0){
            return 0;
        }
        //字符串长度
        int length = s.length();
        //结果长度
        int resultLength = 0;

        Set<Character> sSet = new HashSet<>();

        int slideIndex = 0;
        for(int i = 0; i < length; i++){

            if(i > 0 ){
                sSet.remove(s.charAt(i - 1));
            }
            while(slideIndex < length && !sSet.contains(s.charAt(slideIndex))){
                sSet.add(s.charAt(slideIndex));
                slideIndex ++;
            }
            resultLength = Math.max(sSet.size(),resultLength);
            if(slideIndex == length){
                break;
            }
        }

        return resultLength;

    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println(new Solution3_无重复字符的最长子串().lengthOfLongestSubstring(s));
    }


}
