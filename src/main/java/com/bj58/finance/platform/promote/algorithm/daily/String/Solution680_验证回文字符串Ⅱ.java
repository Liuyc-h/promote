package com.bj58.finance.platform.promote.algorithm.daily.String;

/**
 *  给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution680_验证回文字符串Ⅱ {

    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        //字符长度
        int length = s.length();
        int left = 0;
        int right = length - 1;

        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left ++;
                right --;
            }else{
                //左右标志
                Boolean leftFlag = true;
                Boolean rightFlag = true;
                //定位左右索引
                int rightIndex = right - 1;
                int leftIndex = left + 1;
                while(left < rightIndex){
                    if(s.charAt(left) != s.charAt(rightIndex)){
                        rightFlag= false;
                        break;
                    }
                    left ++;
                    rightIndex --;
                }
                while(leftIndex < right){
                    if(s.charAt(leftIndex) != s.charAt(right)){
                        leftFlag= false;
                        break;
                    }
                    leftIndex ++;
                    right --;
                }
                return leftFlag || rightFlag;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "deeee";
        System.out.println(new Solution680_验证回文字符串Ⅱ().validPalindrome(s));
    }
}
