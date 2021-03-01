package com.bj58.finance.platform.promote.algorithm.again;

/***
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 *
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * 示例 2：
 *
 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution674 {

    public int findLengthOfLCIS(int[] nums) {
        //特殊情况处理
        if(nums == null || nums.length <= 1){
            return nums == null || nums.length == 0 ? 0 : 1;
        }
        //结果
        int result = 0;
        //起始结束索引
        int startIndex = 0;
        int endIndex = 0;
        for(int i = 1; i < nums.length; i++){
            //符合要求的endIndex右移
            if(nums[i] > nums[i - 1]){
                endIndex = i;
                continue;
            }
            result = Math.max(result,endIndex - startIndex + 1);
            endIndex = i;
            startIndex = i;
        }
        result = Math.max(result,endIndex - startIndex + 1);
        return result;


    }

}
