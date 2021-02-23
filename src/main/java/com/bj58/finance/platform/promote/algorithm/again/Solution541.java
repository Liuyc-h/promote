package com.bj58.finance.platform.promote.algorithm.again;


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
public class Solution541 {

    public String reverseStr(String s, int k){

        if(s == null || s.length() == 0 || k <= 1){
            return s;
        }
        //字符数组
        char[] sChar = s.toCharArray();
        int left = 0;
        int right = 0;

        while(right < s.length()){

            for(int i = 0; i < 2 * k  && right < s.length();i++ ){
                right ++;
            }
            //此次截取的长度
            int length = right - left;
            if(length < k){
                reverse(sChar,left,right - 1);
            }else{
                reverse(sChar,left,left + k - 1);
            }
            left = right;
        }
        return new String(sChar);
    }
    //翻转
    private void reverse(char[] array,int left,int right){

        while(left < right){
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left ++;
            right --;
        }
    }
}
