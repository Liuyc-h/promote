package com.bj58.finance.platform.promote.algorithm.again;

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
public class Solution917 {

    public String reverseOnlyLetters(String S) {

        if(S == null || S.length() <= 1){
            return S;
        }
        //字符数组
        char[] sArray = S.toCharArray();

        int left = 0;
        int right = sArray.length -1;

        while(left < right){
            //两个都是字母，进行交换
            if(Character.isLetter(sArray[left]) && Character.isLetter(sArray[right])){
                swap(sArray,left,right);
                left ++;
                right--;
                continue;
            }
            if(!Character.isLetter(sArray[left])){
                left ++;
            }
            if(!Character.isLetter(sArray[right])){
                right --;
            }
        }
        return new String(sArray);

    }

    private void swap(char[] sChar,int left,int right){

        char temp = sChar[left];
        sChar[left] = sChar[right];
        sChar[right] = temp;
    }


    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";

        System.out.println(new Solution917().reverseOnlyLetters(s));
    }
}
