package com.bj58.finance.platform.promote.algorithm.daily.array;

import com.alibaba.fastjson.JSONObject;

/**
 *  给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
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
 * **/
public class Solution34 {

    public int[] searchRange(int[] nums, int target) {

        if(nums == null || nums.length <= 0){
            return new int[]{-1,-1};
        }
        //左起点
        int left  = 0;
        //右起点
        int right = nums.length - 1;
        //起始位置
        int startIndex = -1;
        //结束位置
        int endIndex = -1;
        //二分查找
        while(left <=  right){
            //中间位置
            int middle = (left + right) / 2;

            if(nums[middle] > target){
                right = middle - 1;
                continue;
            }

            if(nums[middle] < target){
                left = middle + 1;
                continue;
            }

            endIndex = Math.max(middle,endIndex);
            if(startIndex == -1){
                startIndex = middle;
            }else{
                startIndex = Math.min(middle,startIndex);
            }
            //两个都相等，直接返回
            if(nums[right] == target && nums[left] == target){
                return new int[]{left,right};
            }
            if(nums[right] > target){
                right --;
            }
            if(nums[left] < target){
                left ++;
            }
        }
        return new int[]{startIndex,endIndex};
    }

    public int[] searchRange1(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        //二分查找
        while (left <= right) {
            int mid = (left + right) / 2;
            // nums[mid] > target,直接跳转
            // nums[mid] = target, 判断是不是寻找左边界，是的话赋值ans
            // nums[mid] < target, 直接跳过了

            //寻找右边界的话，后面不会走到，找到第一个比这个数大的就可以了
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = new int[]{8,8,8,8,8,10};
        int target = 8;

        System.out.println(JSONObject.toJSONString(new Solution34().searchRange(array,target)));
    }
}
