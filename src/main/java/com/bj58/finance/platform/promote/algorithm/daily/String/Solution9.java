package com.bj58.finance.platform.promote.algorithm.daily.String;

/***
 *
 *  判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Solution9 {

    public boolean isPalindrome(int x){

        if(x < 0){
            return false;
        }
        if(x < 10){
            return true;
        }
        //搞成字符串
        String s = x + "";
        //字符串长度
        int length = s.length();
        //中间长度
        int midLength = length / 2;

        int right = length - 1;
        for(int i = 0; i < midLength; i++){
            if(s.charAt(i) != s.charAt(right)){
                return false;
            }
            right --;
        }
        return true;
    }

    public boolean isPalindrome1(int x) {
        if(x < 0){
            return false;
        }
        int div = 1;
        while(x / div >= 10){
            div = div * 10;
        }
        while(x > 0){
            //左边的数
            int left = x / div;
            //右边的数
            int right = x % 10;
            if(left != right){
                return false;
            }
            x = x % div;
            x = x / 10;
            div = div / 100;
        }
        return true;

    }

    public static void main(String[] args) {

        int x = 1;

        System.out.println(new Solution9().isPalindrome(x));

    }
}
