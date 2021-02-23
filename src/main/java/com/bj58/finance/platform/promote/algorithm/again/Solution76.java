package com.bj58.finance.platform.promote.algorithm.again;

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
public class Solution76 {

    //滑窗
    public String minWindow(String s, String t) {

        if(s == null || t == null || t.length() == 0 || s.length() < t.length()){
            return "";
        }
        //将t中得字母加到map里面，方便判断
        Map<Character,Integer> tMap = new HashMap<>();
        for(int i = 0 ; i < t.length(); i++){
            int count = tMap.getOrDefault(t.charAt(i),0) + 1;
            tMap.put(t.charAt(i),count);
        }

        Map<Character,Integer> sMap = new HashMap<>();
        //定义开始结束得索引
        int startIndex = 0;
        int endIndex = Integer.MAX_VALUE;
        //标志是否还=往map里面放字母
        Boolean flag = true;
        int left = 0;
        int right = 0;

        while(right < s.length()){
           //只判断包含得即可
            if(flag && tMap.containsKey(s.charAt(right))){
               int count = sMap.getOrDefault(s.charAt(right),0) + 1;
               sMap.put(s.charAt(right),count);
            }
            //如果两者不想等
            if(!compare(tMap,sMap)){
                right ++;
                flag = true;
                continue;
            }
            //判断长度，重新赋值
            if(right - left < endIndex - startIndex){
                endIndex = right;
                startIndex = left;
            }
            if(sMap.containsKey(s.charAt(left))){
                int count = sMap.get(s.charAt(left));
                if(count == 1){//如果为一，则删除
                    sMap.remove(s.charAt(left));
                }else{
                    sMap.put(s.charAt(left),count - 1);
                }
            }
            flag = false;
            left = left +1;
        }
        return endIndex == Integer.MAX_VALUE ? "" : s.substring(startIndex,endIndex + 1);

    }

    private Boolean compare(Map<Character,Integer> tMap,Map<Character,Integer> sMap){
        if(tMap.size() != sMap.size()){
            return false;
        }
        for(Character flow : tMap.keySet()){

            int tCount = tMap.get(flow);
            int sCount = sMap.get(flow);
            if(tCount > sCount){
                return false;
            }
        }
        return true;
    }
}
