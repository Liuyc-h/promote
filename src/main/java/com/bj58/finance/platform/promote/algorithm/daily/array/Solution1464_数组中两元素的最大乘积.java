package com.bj58.finance.platform.promote.algorithm.daily.array;

/***
 *
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 *
 * 请你计算并返回该式的最大值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,2]
 * 输出：12
 * 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
 * 示例 2：
 *
 * 输入：nums = [1,5,4,5]
 * 输出：16
 * 解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
 * 示例 3：
 *
 * 输入：nums = [3,7]
 * 输出：12
 *  
 *
 * 提示：
 *
 * 2 <= nums.length <= 500
 * 1 <= nums[i] <= 10^3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution1464_数组中两元素的最大乘积 {

    public int maxProduct(int[] nums) {
        //前两个大数
        int firstMax = nums[0] - 1;
        int secondMax = nums[1] - 1;

        //最小得两个数
        int firstMin = nums[0] - 1;
        int secondMin = nums[1] - 1;
        for(int i =2; i< nums.length; i++){

            int maxTemp1 = Math.max(firstMax,nums[i] - 1);
            int maxTemp2 = Math.max(Math.min(firstMax,nums[i] - 1),secondMax);

            firstMax = maxTemp1;
            secondMax = maxTemp2;

            int minTemp1 = Math.min(firstMin,nums[i] - 1);
            int minTemp2 = Math.min(Math.max(secondMin,nums[i] - 1),secondMin);
            firstMin = minTemp1;
            secondMin = minTemp2;
        }
        return firstMin * secondMin > firstMax * secondMax ?
                firstMin * secondMin : firstMax * secondMax;

    }
}
