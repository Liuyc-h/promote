package com.bj58.finance.platform.promote.algorithm.again;

/**
 *  给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *  
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution557 {

    public String reverseWords(String s){

        if(s == null || s.length() <= 1){
            return s;
        }
        //字符串长度
        int length = s.length();
        //s的字符数组
        char[] sArray = s.toCharArray();
        //起始索引
        int index = -1;

        for(int i = 0; i < length - 1; i++){
            //index还未赋值，且字符串当前字符还为‘ ’。
            if(index == -1 ){
                index = s.charAt(i) == ' ' ? -1 : i;
                continue;
            }
            //index已经赋值，且当前字符为空字符
            if(index != -1 && s.charAt(i) == ' '){
                reverse(sArray,index, i - 1);
                index = -1;
            }
        }
        if(index != -1){
            reverse(sArray,index, length - 1);
        }
        return new String(sArray);
    }

    private void reverse(char[] array,int start,int end){

        while(start < end){
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start ++;
            end --;
        }
    }
}
