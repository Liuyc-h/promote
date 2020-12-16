package com.bj58.finance.platform.promote.algorithm.daily.String;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution290 {

    public boolean wordPattern(String pattern, String s) {
        if(pattern == null || s == null){
            return false;
        }
        String[] sArray = s.split(" ");
        if(pattern.length() != sArray.length){
            return false;
        }
        //
        String[] flowArray = new String[26];
        Set<String> set = new HashSet<>();
        for(int i =0; i < pattern.length(); i++){
            int index = pattern.charAt(i) - 'a';
            set.add(sArray[i]);
            if(flowArray[index] == null){
                flowArray[index] = sArray[i];
            }else if(!flowArray[index].equals(sArray[i])){
                return false;
            }
        }
        int count = 0;
        for(int i = 0; i < flowArray.length; i++){
            if(flowArray[i] != null){
                count ++;
            }
        }
        return count == set.size();
    }

    public static void main(String[] args) {

        String pattern = "abba";

        String s = "cat dog dog cat";

        System.out.println(new Solution290().wordPattern(pattern,s));

    }
}
