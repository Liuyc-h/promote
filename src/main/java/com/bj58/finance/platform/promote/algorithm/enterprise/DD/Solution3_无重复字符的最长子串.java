package com.bj58.finance.platform.promote.algorithm.enterprise.DD;

import java.util.HashSet;
import java.util.Set;

/***
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
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * **/
public class Solution3_无重复字符的最长子串 {

    /***
     *
     *
     * **/
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int result = 0;
        //记录字符
        Set<Character> resultSet = new HashSet<>();
        //右边界
        int rightIndex = 0;
        for(int i =0; rightIndex < s.length(); i++){
            //每次到这减掉上一个循环的首个字符串
            if(i > 0 ){
                resultSet.remove(s.charAt(i - 1));
            }
            while(rightIndex < s.length() && !resultSet.contains(s.charAt(rightIndex))){
                resultSet.add(s.charAt(rightIndex));
                rightIndex ++;
            }
            result = Math.max(result,resultSet.size());
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "bbbbb";

        System.out.println(new Solution3_无重复字符的最长子串().lengthOfLongestSubstring(s));
    }
}
