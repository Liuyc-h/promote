package com.bj58.finance.platform.promote.algorithm.daily.String;


import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
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
 * ***/
public class Solution3_无重复的最长字串 {

    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() ==0){
            return 0;
        }
        //字符串长度
        int length = s.length();
        //定义一个set集合去存储字符
        Set<Character> set = new HashSet<>();
        int result = 0;

        int right  = 0;
        for(int i = 0 ; i < length; i++){

            if(i > 0 ){
                set.remove(s.charAt(i -1));
            }
            while(right < length && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right ++;
            }
            result = Math.max(set.size(),result);
            if(right == length){
                break;
            }

        }
        return result;
    }


    public int lengthOfLongestSubstring1(String s) {

        if(s == null || s.length() ==0){
            return 0;
        }
        //字符串长度
        int length = s.length();
        //定义一个set集合去存储字符
        Set<Character> set = new HashSet<>();
        int result = 0;

        int lastStart = 0;
        int right  = 0;

        while(right < length){
            //不包含的话就添加
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right ++;
                continue;
            }
            //获取最新的最大值
            result = Math.max(set.size(),result);
            //移除  上一次开始的点的字符
            set.remove(s.charAt(lastStart));
            lastStart ++;
        }
        result = Math.max(set.size(),result);
        return result;
    }

    public static void main(String[] args) {
        String s = "bbbbbb";

        System.out.println(new Solution3_无重复的最长字串().lengthOfLongestSubstring1(s));
    }
}
