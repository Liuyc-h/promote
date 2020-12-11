package com.bj58.finance.platform.promote.algorithm.daily.String;

/**
 *  给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution5 {
    //中心扩展算法
    public String longestPalindrome(String s) {

        if(s == null || s.length() <= 1){
            return s;
        }
        if(s.length() == 2){
            return s.charAt(0) == s.charAt(1) ? s : s.substring(0,1);
        }
        //字段长度
        int length = s.length();
        //开始索引
        int startIndex = -1;
        //结束索引
        int endIndex = -1;

        for(int i = 1; i < length - 1; i++){
            //本次不
            if(s.charAt(i) != s.charAt(i - 1) && s.charAt(i) != s.charAt(i + 1)
                    && s.charAt(i + 1) != s.charAt(i- 1)){
                continue;
            }
            // i - 1 = i + 1,
            if(s.charAt(i-1) == s.charAt(i + 1)){
                int left = i - 1;
                int right = i+ 1;
                while(left >= 0 && right <= length - 1 && s.charAt(left) == s.charAt(right)){
                    if(right - left  > (endIndex - startIndex)){
                        startIndex = left;
                        endIndex = right;
                    }
                    left --;
                    right ++;
                }
            }
            //i = i - 1
            if(s.charAt(i) == s.charAt(i - 1)){
                int left = i - 1;
                int right = i;
                while(left >= 0 && right <= length - 1 && s.charAt(left) == s.charAt(right)) {
                    if (right - left + 1 > (endIndex - startIndex + 1)) {
                        startIndex = left;
                        endIndex = right;
                    }
                    left--;
                    right++;
                }
            }
            //i = i + 1
            if(s.charAt(i) == s.charAt(i + 1)){
                int left = i;
                int right = i + 1;
                while(left >= 0 && right <= length - 1 && s.charAt(left) == s.charAt(right)) {
                    if (right - left + 1 > (endIndex - startIndex + 1)) {
                        startIndex = left;
                        endIndex = right;
                    }
                    left--;
                    right++;
                }
            }
        }
        return startIndex == endIndex ? s.substring(0,1) : s.substring(startIndex,endIndex + 1);
    }


    public String longestPalindrome1(String s){

        if(s == null || s.length() == 0){
            return s;
        }

        int length = s.length();

        int startIndex = Integer.MAX_VALUE;
        int endIndex = 0;
        for(int i = 0; i < 2 *length - 1; i++){
            int left = i / 2;
            int right = i / 2 + i % 2;
            while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)){

                if(right -left > endIndex - startIndex){
                    startIndex = left;
                    endIndex = right;
                }
                left --;
                right ++;
            }
        }
        return s.substring(startIndex,endIndex + 1);


    }


    public static void main(String[] args) {

        String s = "aba";

        System.out.println(new Solution5().longestPalindrome1(s));

    }
}
