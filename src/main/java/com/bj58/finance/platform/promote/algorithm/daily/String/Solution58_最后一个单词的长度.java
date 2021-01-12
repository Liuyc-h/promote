package com.bj58.finance.platform.promote.algorithm.daily.String;

/**
 *  给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 *  
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution58_最后一个单词的长度 {
    /**
     *  先翻转
     * **/
    public int lengthOfLastWord1(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        //先把字符串翻转
        char[] sArray = s.toCharArray();
        int left = 0,right = sArray.length - 1;
        while(left < right){
            char temp = sArray[left];
            sArray[left] = sArray[right];
            sArray[right] = temp;
            left ++;
            right --;
        }
        //第一个单词前的空格，遇到第一个不是空格的变成true，后续再遇到跳出
        Boolean blankFlag = false;
        int count = 0;
        for(int i = 0; i < sArray.length; i++){
            if(' ' == sArray[i] && blankFlag){
               break;
            }
            if(' ' != sArray[i]){
                blankFlag = true;
                count ++;
            }
        }
        return count;
    }
    //不翻转也能做
    public int lengthOfLastWord(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int sildeIndex = s.length() - 1;
        //第一个单词前的空格，遇到第一个不是空格的变成true，后续再遇到跳出
        Boolean blankFlag = false;
        int count =0;
        while(sildeIndex >= 0){
            if(' ' == s.charAt(sildeIndex) && blankFlag){
                break;
            }
            if( ' ' != s.charAt(sildeIndex)){
                blankFlag = true;
                count ++;
            }
            sildeIndex --;
        }
        return count;
    }
}
