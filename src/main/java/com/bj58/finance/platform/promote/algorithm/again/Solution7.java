package com.bj58.finance.platform.promote.algorithm.again;

/***
 *给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 *  
 *
 * 注意：
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *  
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *  
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution7 {

    public int reverse(int x){

        long flowInt = x;
        Boolean flag = false;
        if( x < 0){
            flag = true;
            flowInt = 0 - flowInt;
        }
        long result = 0;

        while(flowInt > 0){
            result = result * 10 + flowInt % 10;
            flowInt = flowInt / 10;
        }
        if(flag){
            result = -result;
        }
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int) result;
    }
}
