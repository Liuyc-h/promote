package com.bj58.finance.platform.promote.algorithm.again;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 * <p>
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution628 {

    /***
     *  找出最小的两个数和最大的一个数
     *  最小的两个数全负的话 跟最大值相乘 和三个最大的数相比
     * **/
    public int maximumProduct(int[] nums) {
         // 确定最小的两个值
        int minFirst = nums[0];
        int minSecond = nums[1];
        //三个最大的数
        int maxFirst = nums[0];
        int maxSecond = nums[1];
        int maxThird = nums[2];

        for(int i = 2;i < nums.length; i++){
            //最小数的比较
            int mintemp = Math.max(minFirst,nums[i]);
            minFirst = Math.min(minFirst,nums[i]);
            minSecond = Math.min(minSecond,mintemp);
            //小于3的话就不走下面了
            if(i < 3){
                continue;
            }

            int maxTemp1 = Math.min(maxFirst,nums[i]);
            maxFirst = Math.max(maxFirst,nums[i]);

            int maxTemp2 = Math.min(maxSecond,maxTemp1);
            maxSecond = Math.max(maxSecond,maxTemp1);

            maxThird = Math.max(maxThird,maxTemp2);
        }

        int max = Math.max(maxFirst,Math.max(maxSecond,maxThird));
        if(minFirst * minSecond * max >= maxFirst * maxSecond * maxThird){
            return minFirst * minSecond * max;
        }
        return maxFirst * maxSecond * maxThird;
    }
}
