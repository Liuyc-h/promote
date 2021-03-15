package com.bj58.finance.platform.promote.algorithm.daily.array;


/**
 *  给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 *
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 *
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *  
 *
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution414_第三大的数 {

    public int thirdMax(int[] nums) {

        //先定义三个巨小得数
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            //有相等得跳过
            if(nums[i] == firstMax || nums[i] == secondMax || nums[i] == thirdMax){
                continue;
            }
            //比较第一个
            long temp1 = Math.min(firstMax,nums[i]);
            firstMax = Math.max(firstMax,nums[i]);
            //比较第二个
            long temp2 = Math.min(temp1,secondMax);
            secondMax = Math.max(secondMax,temp1);
            //比较第三个
            thirdMax = Math.max(temp2,thirdMax);
        }

        if(firstMax == Long.MIN_VALUE || secondMax == Long.MIN_VALUE || thirdMax == Long.MIN_VALUE){
            return (int)Math.max(Math.max(firstMax,secondMax),thirdMax);
        }
        return (int)Math.min(Math.min(firstMax,secondMax),thirdMax);
    }


}
