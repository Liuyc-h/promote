package com.bj58.finance.platform.promote.algorithm.again;

import java.util.ArrayList;
import java.util.Arrays;

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
public class Solution567 {

    public boolean checkInclusion(String s1, String s2){

        long startMill = System.currentTimeMillis();
        try{
            if(s1
                    == null || s2 ==null || s1.length() > s2.length()){
                return false;
            }
            //重新设置数组
            char[] s1Char = s1.toCharArray();
            Arrays.sort(s1Char);
            String newStr = new String(s1Char);
            //开始索引
            int startIndex = 0;
            for(int i = s1.length(); i <= s2.length(); i++){

                String subStr = s2.substring(startIndex,i);
                char[] sunArray = subStr.toCharArray();
                Arrays.sort(sunArray);
                if(newStr.equals(new String(sunArray))){
                    return true;
                }
                startIndex ++;
            }
            return s1.length() == s2.length() ? s1.equals(s2) : false;
        }finally {
            long endMill = System.currentTimeMillis();
            System.out.println(endMill - startMill);
        }

    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(new Solution567().checkInclusion(s1,s2));
    }
}
