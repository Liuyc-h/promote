package com.bj58.finance.platform.promote.algorithm.daily.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Solution242 {

    public boolean isAnagram(String s, String t) {

        if( s == null || t ==null || s.length() != t.length()){
            return false;
        }
        Map<Character,Integer> sMap = new HashMap<>();

        for(int i =0; i< s.length(); i++){
            sMap.put(s.charAt(i),sMap.getOrDefault(s.charAt(i),0) + 1);
        }

        for(int j =0; j < t.length(); j++){
            int value = sMap.getOrDefault(t.charAt(j),0);
            if(value == 0){
                return false;
            }
            value = value - 1;
            if(value <= 0){
                sMap.remove(t.charAt(j));
            }else{
                sMap.put(t.charAt(j),value);
            }
        }
        return sMap.size() == 0;
    }


    public boolean isAnagram1(String s, String t) {

        if( s == null || t ==null || s.length() != t.length()){
            return false;
        }
        int[] tArray = new int[26];

        int[] sArray = new int[26];

        for(int i =0; i< s.length(); i++){
            int sIndex = s.charAt(i) - 'a';
            int tIndex = t.charAt(i) - 'a';
            tArray[tIndex] ++;
            sArray[sIndex] ++;
        }
        for(int i = 0; i< 26; i++){
            if(tArray[i] != sArray[i]){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        for(int i =0; i< str1.length; i++){
            if(str1[i] != str2[i]){
                return false;
            }
        }
        return true;
    }




    public static void main(String[] args) {

        String s = "anagram";

        String t = "nagaram";

        System.out.println(new Solution242().isAnagram1(s,t));
    }
}
