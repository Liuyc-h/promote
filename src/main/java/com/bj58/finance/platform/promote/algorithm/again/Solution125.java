package com.bj58.finance.platform.promote.algorithm.again;

/**
 *  给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * ***/
public class Solution125 {

    public boolean isPalindrome(String s){
        if(s == null || s.length() == 0){
            return s == null ? false :true;
        }
        //左右指针
        int left = 0;
        int right = s.length() - 1;
        //左右标志
        Boolean leftFlag = false;
        Boolean  rightFlag = false;

        while(left < right){

            if(!leftFlag && Character.isLetterOrDigit(s.charAt(left))){
                leftFlag = true;
            }else{
                left  = leftFlag ? left : left + 1;
            }
            if(!rightFlag && Character.isLetterOrDigit(s.charAt(right))){
                rightFlag = true;
            }else{
                right = rightFlag ? right : right - 1;
            }
            if(rightFlag && leftFlag ){
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                right --;
                left ++;
                rightFlag = false;
                leftFlag = false;
            }
        }
        return true;

    }
}
