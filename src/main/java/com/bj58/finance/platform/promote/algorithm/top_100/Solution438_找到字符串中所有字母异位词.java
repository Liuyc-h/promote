package com.bj58.finance.platform.promote.algorithm.top_100;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
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
 *
 *
 * */
public class Solution438_找到字符串中所有字母异位词 {

    public List<Integer> findAnagrams(String s, String p) {
        //结果list
        List<Integer> resultList = new ArrayList<>();
        if(s == null || p == null){
            return resultList;
        }
        //字符串s的长度
        int sLength = s.length();
        //字符串p的长度
        int pLength = p.length();
        if(sLength < pLength){
            return resultList;
        }
        //p字母的字符数量,用hash也可以，不过比较麻烦，但是比较适用于各个场景
        Map<Character,Integer> pMap = new HashMap<>();
        for(int i = 0; i < pLength; i++){
            int count = pMap.getOrDefault(p.charAt(i),0) + 1;
            pMap.put(p.charAt(i),count);
        }

        Map<Character,Integer> sMap = new HashMap<>();
        for(int i = 0; i < pLength; i++){
            int count = sMap.getOrDefault(s.charAt(i),0) + 1;
            sMap.put(s.charAt(i),count);
        }
        if(judge(pMap,sMap)){
            resultList.add(0);
        }
        for(int i = 1; i<= sLength - pLength; i++){
            Character key = s.charAt(i - 1);
            int keyCount = sMap.get(key);
            if(keyCount == 1){
                sMap.remove(key);
            }else{
                sMap.put(key,keyCount - 1);
            }
            sMap.put(s.charAt(pLength + i - 1),sMap.getOrDefault(s.charAt(pLength + i - 1),0) + 1);
            if(judge(sMap,pMap)){
                resultList.add(i);
            }
        }
        return resultList;

    }
    /**
     *  判断是否相等
     * */
    private Boolean judge(Map<Character,Integer> sMap,Map<Character,Integer> pMap){

        if(sMap.keySet().size() != pMap.keySet().size()){
            return false;
        }
        for(Character key : sMap.keySet()){
            if(!pMap.containsKey(key) || !sMap.get(key).equals(pMap.get(key))){
                return false;
            }
        }
        return true;
    }



    public List<Integer> findAnagrams2(String s, String p) {
        //结果list
        List<Integer> resultList = new ArrayList<>();
        if(s == null || p == null){
            return resultList;
        }
        //字符串s的长度
        int sLength = s.length();
        //字符串p的长度
        int pLength = p.length();
        if(sLength < pLength){
            return resultList;
        }
        //p字母的字符数量,用hash也可以，不过比较麻烦，但是比较适用于各个场景
        int[] pCharArray = new int[26];
        for(int i = 0; i < pLength; i++){
            int index = p.charAt(i) - 'a';
            pCharArray[index] ++;
        }

        int[] charArray = new int[26];
        for(int i = 0; i < pLength; i++){
            charArray[s.charAt(i) - 'a'] ++;
        }
        if(judge2(charArray,pCharArray)){
            resultList.add(0);
        }
        for(int i = 1; i<= sLength - pLength; i++){
            charArray[s.charAt( i-1) - 'a'] --;
            charArray[s.charAt(i + pLength - 1) - 'a'] ++;
            if(judge2(charArray,pCharArray)){
                resultList.add(i);
            }
        }
        return resultList;
    }


    public List<Integer> findAnagrams3(String s, String p) {
        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();

        // 接收最后返回的结果
        List<Integer> ans = new ArrayList<>();

        // 定义一个 needs 数组来看 arrP 中包含元素的个数
        int[] needs = new int[26];
        // 定义一个 window 数组来看滑动窗口中是否有 arrP 中的元素，并记录出现的个数
        int[] window = new int[26];

        // 先将 arrP 中的元素保存到 needs 数组中
        for (int i = 0; i < arrP.length; i++) {
            needs[arrP[i] - 'a'] += 1;
        }

        // 定义滑动窗口的两端
        int left = 0;
        int right = 0;

        // 右窗口开始不断向右移动
        while (right < arrS.length) {
            int curR = arrS[right] - 'a';
            right++;
            // 将右窗口当前访问到的元素 curR 个数加 1
            window[curR] += 1;

            // 当 window 数组中 curR 比 needs 数组中对应元素的个数要多的时候就该移动左窗口指针
            while (window[curR] > needs[curR]) {
                int curL = arrS[left] - 'a';
                left++;
                // 将左窗口当前访问到的元素 curL 个数减 1
                window[curL] -= 1;
            }

            // 这里将所有符合要求的左窗口索引放入到了接收结果的 List 中
            if (right - left == arrP.length) {
                ans.add(left);
            }
        }
        return ans;
    }

    /**
     *  判断是否相等
     * */
    private Boolean judge2(int[] num1,int[] num2){
        for(int i =0; i< num1.length; i++){
            if(num1[i] != num2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "aa";

        String p = "bb";

        System.out.println(JSONObject.toJSONString(new Solution438_找到字符串中所有字母异位词().findAnagrams(s,p)));

    }
}
