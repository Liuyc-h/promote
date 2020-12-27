package com.bj58.finance.platform.promote.algorithm.daily.String;

import java.util.*;

/***
 *给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 * 通过次数65,374提交次数135,218
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class Solution205 {

    public boolean isIsomorphic(String s, String t) {

        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        Map<Character, Set<Integer>> sMap = new HashMap<>();
        Map<Character, Set<Integer>> tMap = new HashMap<>();

        for(int i = 0; i< s.length(); i++){
            char currS = s.charAt(i);
            char currT = t.charAt(i);
            Set<Integer> sSet = sMap.getOrDefault(currS,new HashSet<>());
            sSet.add(i);
            Set<Integer> tSet = tMap.getOrDefault(currT,new HashSet<>());
            tSet.add(i);;
            sMap.put(currS,sSet);
            tMap.put(currT,tSet);
        }
        for(Set<Integer> indexList : sMap.values()){
            Set<Integer> tIndex = null;
            for(Integer index : indexList){
                if(tIndex == null){
                    tIndex = tMap.getOrDefault(t.charAt(index),new HashSet<>());
                }
                if(tIndex.size() != indexList.size()){
                    return false;
                }
                if(!tIndex.contains(index)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIsomorphic1(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        Map<Character,Character> sMap = new HashMap<>();
        Map<Character,Character> tMap = new HashMap<>();

        for(int i =0 ; i< s.length(); i++){

            char currS = s.charAt(i);
            char currT = t.charAt(i);

            if((sMap.containsKey(currS) && sMap.get(currS) != currT) || (tMap.containsKey(currT) && tMap.get(currT) != currS)){
                return false;
            }
            sMap.put(currS,currT);
            tMap.put(currT,currS);
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

    public static void main(String[] args) {
        String t = "aa";
        String s = "ab";

        System.out.println(new Solution205().isIsomorphic2(s,t));
    }
}
