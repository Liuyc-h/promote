package com.bj58.finance.platform.promote.algorithm.daily.String;

import java.util.HashSet;
import java.util.Set;

/**
 *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class Solution3 {

    public int lengthOfLongestSubstring(String s){
        if(s == null || s.length() <= 0){
            return 0;
        }
        int noRepeatSize = 0;
        Set<Character> cSet = new HashSet<>();
        //字符串长度
        int length = s.length();
        //右端点
        int right = 0;

        for(int i = 0; i< length; i++){
            //每经过一次，删除前一个导入的char
            if(i != 0){
                cSet.remove(s.charAt(i - 1));
            }

            while(right < length && !cSet.contains(s.charAt(right))){
                cSet.add(s.charAt(right));
                right ++;
            }
            noRepeatSize = Math.max(noRepeatSize,cSet.size());
            if(right == length){
                break;
            }

        }
        return noRepeatSize;
    }

    public static void main(String[] args) {
        String s = "bbbbbb";

        System.out.println(new Solution3().lengthOfLongestSubstring(s));
    }
}
