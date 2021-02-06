package com.bj58.finance.platform.promote.algorithm.daily.String;

/**
 *
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution434_字符串中的单词数 {

    public int countSegments(String s) {

        int result = 0;
        if(s == null || s.length() == 0){
            return result;
        }
         //s的长度
        int length = s.length();
        int index = -1;
        for(int i = 0; i < length; i++ ){
             //index为-1，当前字母为空格，证明没有到
            if(index == -1 && s.charAt(i) == ' '){
                continue;
            }
            //index 为-1，不为空。进行赋值
            if(index == -1 && s.charAt(i) != ' '){
                index = i;
                continue;
            }
            if(index != -1 && s.charAt(i) == ' '){
                result ++;
                index = -1;
            }
        }
        result = index == -1 ? result : result + 1;
        return result;


    }
}
