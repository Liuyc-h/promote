package com.bj58.finance.platform.promote.algorithm.again;

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
public class Solution414 {

    public int thirdMax(int[] nums) {

        if(nums.length == 1 || nums.length == 2){
            return nums.length == 1 ? nums[0] : Math.max(nums[0],nums[1]);
        }
        //先对三个数赋值
        int firstMax = nums[0];
        int secondMax = nums[1];
        int thirdMax = nums[2];

        for(int i = 3; i< nums.length; i++){
            //三个数中有一个和其中的数相等，则跳出，继续下一个循环
            if(firstMax == nums[i] || secondMax == nums[i] || thirdMax == nums[i]){
                continue;
            }
             //如果其中两个数相等，则替换一个
            if(firstMax == secondMax){
                firstMax = nums[i];
                continue;
            }
            if(firstMax == thirdMax){
                firstMax = nums[i];
                continue;
            }
            if(secondMax == thirdMax){
                secondMax = nums[i];
                continue;
            }
            //接下来是三个数都不想等，且nums[i] 跟其他数也不相等的情况了
            int temp1 = Math.min(firstMax,nums[i]);
            firstMax = Math.max(firstMax,nums[i]);

            int temp2 = Math.min(secondMax,temp1);
            secondMax = Math.max(secondMax,temp1);

            thirdMax = Math.max(thirdMax,temp2);

        }
        if(secondMax == firstMax || firstMax == thirdMax || secondMax == thirdMax){
            return Math.max(firstMax,Math.max(secondMax,thirdMax));
        }
        return Math.min(firstMax,Math.min(secondMax,thirdMax));
    }
}
