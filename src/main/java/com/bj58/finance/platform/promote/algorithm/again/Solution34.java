package com.bj58.finance.platform.promote.algorithm.again;

/***
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * ***/
public class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        //结果
        int[] result = new int[]{-1,-1};
        if(nums == null || nums.length == 0){
            return result;
        }
        //定义左右指针
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){

            int middle = (left + right) / 2;
            //
            if(nums[middle] > target){
                right = middle - 1;
                continue;
            }
            //
            if(nums[middle] < target){
                left = middle + 1;
                continue;
            }

            if(nums[right] == target && nums[left] == target){
                result[0] = left;
                result[1] = right;
                return result;
            }
            if(result[0] == -1){
                result[0] = middle;
            }else{
                result[0] = Math.min(middle,result[0]);
            }
            result[1] = Math.max(middle,result[1]);
            if(nums[right] > target){
                right --;
            }
            if(nums[left] < target){
                left ++;
            }
        }
        return result;
    }
}
