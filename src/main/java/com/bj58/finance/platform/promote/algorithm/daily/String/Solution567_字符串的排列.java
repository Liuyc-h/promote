package com.bj58.finance.platform.promote.algorithm.daily.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * ***/
public class Solution567_字符串的排列 {


    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() > s2.length()){
            return false;
        }
        Map<Character,Integer> s1Map = new HashMap<>();
        Map<Character,Integer> s2Map = new HashMap<>();
        //s1的长度
        int siLength = s1.length();
        for(int i =0; i< siLength; i++){
            int count = s1Map.getOrDefault(s1.charAt(i),0) + 1;
            s1Map.put(s1.charAt(i),count);
        }
        //s2的长度
        int s2Length = s2.length();
        //定义左右指针，
        int left = 0;
        int right = 0;
        while(right <= s2Length){
            if(right - left  != siLength){
                int count = s2Map.getOrDefault(s2.charAt(right),0) + 1;
                s2Map.put(s2.charAt(right),count);
                right ++;
                continue;
            }
            Boolean flag = compareMap(s1Map,s2Map);
            if(flag){
                return true;
            }
            s2Map.put(s2.charAt(left),s2Map.get(s2.charAt(left)) - 1);
            if(s2Map.get(s2.charAt(left)) == 0){
                s2Map.remove(s2.charAt(left));
            }
            if(right == s2.length()){
                break;
            }
            left ++;
        }
        return false;
    }

    private Boolean compareMap(Map<Character,Integer> s1Map,Map<Character,Integer> s2Map){
        if(s1Map.size() != s2Map.size()){
            return false;
        }
        for(Character arr : s1Map.keySet()){
            int count1 = s1Map.getOrDefault(arr,0);
            int count2 = s2Map.getOrDefault(arr,0);
            if(count1 != count2){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";

        System.out.println(new Solution567_字符串的排列().checkInclusion(s1,s2));

    }
}
