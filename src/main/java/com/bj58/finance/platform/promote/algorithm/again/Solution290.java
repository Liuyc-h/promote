package com.bj58.finance.platform.promote.algorithm.again;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
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

    public boolean wordPattern(String pattern, String s){
        //特殊情况特殊处理
        if(pattern == null || s == null){
            return false;
        }
        String[] strs = s.split(" ");
        if(pattern.length() != strs.length){
            return false;
        }
        //创建映射关系
        Map<Character,String> mapping = new HashMap<>();
        Set<String> valueSet = new HashSet<>();
        for(int i  =0; i < pattern.length(); i++){

            if(!mapping.containsKey(pattern.charAt(i))){
                if(valueSet.contains(strs[i])){
                    return false;
                }
                mapping.put(pattern.charAt(i) ,strs[i]);
                valueSet.add(strs[i]);
            }else{
                if(mapping.get(pattern.charAt(i)) == null || !mapping.get(pattern.charAt(i)).equals(strs[i])){
                    return false;
                }
            }
        }
        return true;

    }
}
