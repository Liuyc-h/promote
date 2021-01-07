package com.bj58.finance.platform.promote.algorithm.daily.String;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
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
 * **/
public class Solution125_验证回文串 {

    //
    public boolean isPalindrome(String s) {
        if(s == null ){
            return false;
        }
        List<Character> resultList = new ArrayList<>();
        for(int i =0; i< s.length(); i++){
            char curr = s.charAt(i);
            if(Character.isLetterOrDigit(curr)){
                resultList.add(curr);
            }
        }
        int size = resultList.size();
        if(size == 0){
            return true;
        }
        int left,right;
        if(size % 2 == 0){
            left = size / 2 - 1;
            right = size / 2;
        }else{
            left = size / 2;
            right = size / 2;
        }
        while (left >= 0 && right < size) {
            if(Character.isDigit(resultList.get(left)) && !resultList.get(left).equals(resultList.get(right))){
                return false;
            }
            char leftChar = resultList.get(left);
            char rightChar = resultList.get(right);
            if(Character.toUpperCase(leftChar) != Character.toUpperCase(rightChar)){
                return false;
            }
            left --;
            right ++;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Solution125_验证回文串().isPalindrome1(" "));
    }

    /***
     *
     * 双指针试试
     * **/
    public boolean isPalindrome1(String s){
        if(s == null){//特殊情况处理
            return false;
        }
        if(s.length() == 0){//这种情况为true
            return true;
        }
        int length = s.length();
        //左指针
        int left = 0;
        //右指针
        int right = length - 1;
        //左指针找到符合条件的标志
        Boolean leftFlag = false;
        //右指针找到符合条件的标志
        Boolean rightFlag = false;

        while(left <= right){
            //没找到符合条件的并且也不是
            if(!leftFlag && Character.isLetterOrDigit(s.charAt(left))){
                leftFlag = true;
            }
            if(!leftFlag && !Character.isLetterOrDigit(s.charAt(left))){
                left ++;
            }
            if(!rightFlag && Character.isLetterOrDigit(s.charAt(right))){
                rightFlag = true;
            }
            if(!rightFlag && !Character.isLetterOrDigit(s.charAt(right))){
                right --;
            }

            if(rightFlag && leftFlag){
                char first = s.charAt(left);
                char second = s.charAt(right);
                if(Character.toLowerCase(first) != Character.toLowerCase(second)){
                    return false;
                }
                rightFlag = false;
                leftFlag = false;
                right --;
                left ++;
            }
        }
        return true;
    }
}
