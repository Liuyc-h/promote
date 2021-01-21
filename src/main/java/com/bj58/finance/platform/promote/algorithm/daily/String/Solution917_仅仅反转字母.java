package com.bj58.finance.platform.promote.algorithm.daily.String;

/***
 *  给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *  
 *
 * 提示：
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S 中不包含 \ or "
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution917_仅仅反转字母 {

    public String reverseOnlyLetters(String S) {
        if(S == null || S.length() <= 1){
            return S;
        }
        //字符数组
        char[] array = S.toCharArray();
        int length = array.length;
        //定义双指针
        int left = 0;
        int right = length - 1;

        while(left < right){

            if(left < right && !Character.isLetter(array[left])){
                left ++;
            }
            if(left < right && !Character.isLetter(array[right])){
                right --;
            }
            //都是字母
            if(Character.isLetter(array[right]) &&
                    Character.isLetter(array[left])){
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left ++;
                right --;
            }
        }
        return new String(array);
    }
}
