package com.bj58.finance.platform.promote.algorithm.daily.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "paper", t = "title"
 * 输出：true
 *  
 *
 * 提示：
 *
 * 可以假设 s 和 t 长度相同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution205_同构字符串 {

    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        Map<Character,Character> mapping = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for(int i = 0; i< s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(!mapping.containsKey(sChar) && set.contains(tChar)){
               return false;
            }
            if(!mapping.containsKey(sChar) && !set.contains(tChar)){
                mapping.put(sChar,tChar);
                set.add(tChar);
                continue;
            }
            if(mapping.containsKey(sChar) && mapping.get(sChar).equals(tChar)){
                continue;
            }
            if(mapping.containsKey(sChar) && !mapping.get(sChar).equals(tChar)){
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        Map<Character,Character> sMap = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int length = s.length();
        for(int i =0 ; i< length; i++){

            char currS = s.charAt(i);
            char currT = t.charAt(i);
            //如果存在映射，判断等不等，不等的话直接抛出
            if(sMap.containsKey(currS)){
                if(sMap.get(currS) != currT){
                    return false;
                }
                continue;
            }
            //如果不存在映射，value集合包含currT，返回false
            if(set.contains(currT)){
                return false;
            }
            sMap.put(currS,currT);
            set.add(currT);
        }
        return true;
    }
}
