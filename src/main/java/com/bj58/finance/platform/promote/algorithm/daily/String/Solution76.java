package com.bj58.finance.platform.promote.algorithm.daily.String;

import java.util.HashMap;
import java.util.Map;

/**
 *  给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Solution76 {

    public String minWindow(String s, String t){
        //s的字符和出现的频率映射
        Map<Character,Integer> sMap = new HashMap<>();
        //t的字符和出现的频率映射
        Map<Character,Integer> tMap = new HashMap<>();
        if( s == null || t == null || s.length() == 0 || t.length() == 0){
            return "";
        }
        //t的字符映射
        for(int i = 0 ; i < t.length(); i++ ){
            int count = tMap.getOrDefault(t.charAt(i),0) + 1;
            tMap.put(t.charAt(i),count);
        }
        //s的字符串长度
        int sLength = s.length();
        //左节点
        int right = 0;
        //右节点
        int left = 0;

        while(right < sLength){

            char key = s.charAt(right);
            int value = sMap.getOrDefault(key,0) + 1;
            sMap.put(key,value);

            if(){

            }

            right ++;


        }
    }
}
