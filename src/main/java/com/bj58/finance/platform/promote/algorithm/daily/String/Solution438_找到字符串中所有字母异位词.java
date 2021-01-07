package com.bj58.finance.platform.promote.algorithm.daily.String;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution438_找到字符串中所有字母异位词 {

    public List<Integer> findAnagrams(String s, String p){
        //结果
        List<Integer> resultList = new ArrayList<>();
        //特殊情况
        if(s == null || p == null || s.length() < p.length()){
            return resultList;
        }
        //s字符串长度
        int sLength = s.length();
        //p字符串长度
        int pLength = p.length();
        //开始索引
        int currStart = 0;
        int preStart = 0;
        int[] sArray = new int[26];
        int[] pArray = new int[26];
        for(int i = 0; i< pLength; i++){
            sArray[s.charAt(i) - 'a'] ++;
            pArray[p.charAt(i) - 'a'] ++;
        }
        if(isEquals(sArray,pArray)){
            resultList.add(currStart);
            currStart ++;
        }else{
            currStart ++;
        }
        for(int i = pLength; i < sLength; i++ ){
            sArray[s.charAt(preStart) - 'a'] --;
            sArray[s.charAt(i) - 'a'] ++;
            if(isEquals(sArray,pArray)){
                resultList.add(currStart);
            }
            preStart = currStart;
            currStart ++;
        }
        return resultList;
    }
    //两个数组是否相等
    private boolean isEquals(int[] first,int[] second){

        if(first.length != second.length ){
            return false;
        }
        for(int i =0; i< first.length; i++){
            if(first[i] != second[i]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        String s = "cbaebabacd";

        System.out.println(JSONObject.toJSONString(new Solution438_找到字符串中所有字母异位词().findAnagrams(s,"abc")));

    }
}
