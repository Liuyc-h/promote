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

    //s的字符和出现的频率映射
    private Map<Character,Integer> sMap = new HashMap<>();
    //t的字符和出现的频率映射
    private Map<Character,Integer> tMap = new HashMap<>();

    public String minWindow(String s, String t){

        if( s == null || t == null || s.length() == 0
                || t.length() == 0 || s.length() < t.length()){
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
        //左边界
        int leftBound = 0;
        //右边界
        int rightBound = 0;
        //先定义一个巨长得长度，后面好比较
        int length = Integer.MAX_VALUE;

        while(right < sLength){

            char key = s.charAt(right);
            int value = sMap.getOrDefault(key,0) + 1;
            sMap.put(key,value);

            while(check() && left <= right){

                if(length > right - left + 1){
                    leftBound = left;
                    rightBound = right;

                    length = right -left + 1;
                }
                int count = sMap.getOrDefault(s.charAt(left),0) - 1;
                sMap.put(s.charAt(left),count);
                left ++;
            }
            right ++;
        }
        return length == (rightBound - leftBound + 1)
                ? s.substring(leftBound,rightBound + 1) : "";
    }
    /**
     *  校验下是否触发调用
     * **/
    private Boolean check(){

        for(Map.Entry entry : tMap.entrySet()){

            char key = (char)entry.getKey();
            int value = (int)entry.getValue();

            int sCount = sMap.getOrDefault(key,0);
            if(sCount < value){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "a";
        String t = "b";

        System.out.println(new Solution76().minWindow(s,t));
    }
}
