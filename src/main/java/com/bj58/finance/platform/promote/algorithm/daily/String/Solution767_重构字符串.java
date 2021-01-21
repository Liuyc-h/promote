package com.bj58.finance.platform.promote.algorithm.daily.String;

import java.util.HashMap;
import java.util.Map;

/**
 *给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * **/
public class Solution767_重构字符串 {

    public String reorganizeString(String S) {
        //特殊处理
        if(S == null || S.length() < 2){
            return S;
        }
        //S字符串长度
        int length = S.length();
        //找出
        char maxCountChar = S.charAt(0);
        //key 为字符  value为字符出现得次数
        Map<Character,Integer> charMap = new HashMap<>();
        for(int i = 0;i < length; i++){
            char flow = S.charAt(i);
            charMap.put(flow,charMap.getOrDefault(flow,0) + 1);
            maxCountChar = charMap.getOrDefault(maxCountChar,0)
                    > charMap.get(flow) ? maxCountChar : flow;
        }
        int maxCount = charMap.get(maxCountChar);
        if(maxCount > (length + 1) / 2){
            return "";
        }
        int index = 0;
        char[] resultArray = new char[length];
        for(int i = 0; i< maxCount; i++){
            resultArray[index] = maxCountChar;
            index = index + 2;
        }
        charMap.remove(maxCountChar);
        for(char flow : charMap.keySet()){
            int count = charMap.get(flow);
            for(int i = 0; i< count; i++){
                if(index > length - 1){
                    index = 1;
                }
                resultArray[index] = flow;
                index = index + 2;
            }
        }
        return new String(resultArray);
    }
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new Solution767_重构字符串().reorganizeString(s));
    }
}
