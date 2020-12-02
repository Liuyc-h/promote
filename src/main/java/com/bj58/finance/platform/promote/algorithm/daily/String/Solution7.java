package com.bj58.finance.platform.promote.algorithm.daily.String;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution7 {

    public int reverse(int x) {
        //是否是负数的标识
        Boolean negativeFlag = false;
        if(x < 0){
            negativeFlag = true;
        }
        x = Math.abs(x);
        long result = 0;
        while( x / 10 > 0){
            int bal = x % 10;
            x = x / 10;
            result = result * 10 + bal;
        }
        if(x % 10 > 0){
            result = result * 10 + x % 10;
        }
        if(negativeFlag){
            result = - result;
        }
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int)result;

    }

    public static void main(String[] args) {

        int i = -120;

        System.out.println(new Solution7().reverse(i));

    }
}
