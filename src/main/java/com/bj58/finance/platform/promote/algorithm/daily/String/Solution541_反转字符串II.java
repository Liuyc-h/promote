package com.bj58.finance.platform.promote.algorithm.daily.String;

/***
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *  
 *
 * 提示：
 *
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * ***/
public class Solution541_反转字符串II {

    public String reverseStr(String s, int k) {
        if(s == null || s.length() == 0){
            return s;
        }
        //转换为字符串
        char[] sChar = s.toCharArray();
        //双指针试一下
        int left = 0;
        int right = 0;

        while(right < s.length()){
            //在s.length下先截取 2 * k个元素
            while(right - left + 1 < 2 *k && right < s.length() - 1){
                right ++;
            }
            //实际长度
            int actualLength = right - left + 1;
            if(actualLength >=  k){
                reverseArray(sChar,left,left + k - 1);
            }else{
                reverseArray(sChar,left,right);
            }
            left = right + 1;
            right = right + 1;
        }
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
        String s = "abcd";
        System.out.println(new Solution541_反转字符串II().reverseStr(s,3));
    }
}
