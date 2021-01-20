package com.bj58.finance.platform.promote.algorithm.daily.String;

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
public class Solution557_反转字符串中的单词III {

    public String reverseWords(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }
        //数组长度
        int length = s.length();
        char[] sChar = s.toCharArray();
        //开始结束索引
        int startIndex = 0;
        for(int i = 0; i < s.length();i++){
            //不是空格就跳出
            if(sChar[i] != ' '){
                continue;
            }
            //翻转
            reverseArray(sChar,startIndex,i - 1);
            startIndex = i + 1;
        }
        reverseArray(sChar,startIndex,length - 1);
        return new String(sChar);
    }

    //翻转数组
    private void reverseArray(char[] array,int start,int end){

        while(start < end){
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start ++;
            end --;
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";

        System.out.println(new Solution557_反转字符串中的单词III().reverseWords(s));
    }
}
