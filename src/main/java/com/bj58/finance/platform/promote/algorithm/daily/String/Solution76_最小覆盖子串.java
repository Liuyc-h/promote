package com.bj58.finance.platform.promote.algorithm.daily.String;

import java.util.HashMap;
import java.util.Map;

/**
 *给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *  
 *
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution76_最小覆盖子串 {
    //滑窗
    public String minWindow(String s, String t) {
        //特殊情况处理
        if(s == null || t == null || t.length() == 0 || s.length() == 0){
            return "";
        }
        //先将t字符串存入map中
        Map<Character,Integer> tMap = new HashMap<>();
        for(int i = 0; i< t.length();i++){
            int count = tMap.getOrDefault(t.charAt(i),0) + 1;
            tMap.put(t.charAt(i),count);
        }

        Map<Character,Integer> sMap = new HashMap<>();
        //左右指针
        int left = 0;
        int right = 0;
        //左右索引
        int startIndex = 0;
        int endIndex = Integer.MAX_VALUE;

        while(right < s.length()){

            if(right < s.length() && tMap.containsKey(s.charAt(right))){
                sMap.put(s.charAt(right),sMap.getOrDefault(s.charAt(right),0) + 1);
            }
            //符合要求
            while(compareMap(tMap,sMap) && left <= right){
                if (endIndex - startIndex > (right - left)){
                    endIndex = right;
                    startIndex = left;
                }
                if(tMap.containsKey(s.charAt(left))){
                    int count = sMap.getOrDefault(s.charAt(left),0);
                    sMap.put(s.charAt(left),count - 1);
                }
                left ++;
            }
            right ++;
        }
        return endIndex == Integer.MAX_VALUE ? "" : s.substring(startIndex,endIndex + 1);


    }
    //比较字符串是否符合要求
    private Boolean compareMap(Map<Character,Integer> tMap,Map<Character,Integer> sMap){

        if(tMap.keySet().size() != sMap.keySet().size()){
            return false;
        }
        for(Character flow : tMap.keySet()){
            int tCount = tMap.get(flow);
            int sCount = sMap.getOrDefault(flow,0);
            if(sCount < tCount){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(new Solution76_最小覆盖子串().minWindow(s,t));
    }


}
