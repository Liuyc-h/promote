package com.bj58.finance.platform.promote.algorithm.daily.String;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
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
        //字符集合
        char[] array = s.toCharArray();
        //开始索引
        int startIndex = 0;
        //滑窗
        int slideIndex = 0;
        while(slideIndex < array.length){
            if(' ' != array[slideIndex]){
                slideIndex ++;
                continue;
            }
            int left = startIndex;
            int right = slideIndex - 1;
            while(left < right){
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left ++;
                right --;
            }
            slideIndex ++;
            startIndex = slideIndex;
        }
        int left = startIndex;
        int right = slideIndex - 1;
        while(left < right){
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left ++;
            right --;
        }
        return new String(array);
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";

        System.out.println(new Solution557_反转字符串中的单词III().reverseWords(s));
    }
}
