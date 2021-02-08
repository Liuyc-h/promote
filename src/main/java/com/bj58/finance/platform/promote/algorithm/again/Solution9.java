package com.bj58.finance.platform.promote.algorithm.again;

/***
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
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
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * ***/
public class Solution9 {

    public boolean isPalindrome(int x) {

        if( x < 0){
            return false;
        }
        if( x < 10){
            return true;
        }
        int flowInt = x;
        int n = 1;
        while ( flowInt >= 10){
            n = n * 10;
            flowInt = flowInt / 10;
        }

        while(n > 1){

            int left =  x / n;
            int right = x % 10;

            if(left != right){
                return false;
            }
            x = x % n;
            x = x / 10;
            n = n / 100;
        }
        return true;
    }

    public static void main(String[] args) {
        int s = 1000021;

        System.out.println(new Solution9().isPalindrome(s));
    }


}
