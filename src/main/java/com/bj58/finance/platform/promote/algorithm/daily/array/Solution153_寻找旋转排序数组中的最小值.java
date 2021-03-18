package com.bj58.finance.platform.promote.algorithm.daily.array;


/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 *
 * 请找出其中最小的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数都是 唯一 的
 * nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * **/
public class Solution153_寻找旋转排序数组中的最小值 {

    public int findMin(int[] nums) {
        //特殊情况
        if(nums.length == 1){
            return nums[0];
        }
        //数组的长度
        int length = nums.length;
        //这中情况证明未进行旋转，直接返回nums[0] 即可
        if(nums[0] < nums[length - 1]){
            return nums[0];
        }
        // 定义左右指针
        int left = 0;
        int right = length - 1;

        while(left <= right){
            //找到中间节点
            int middle = (left + right) / 2;
            //此时如果 middle > middle + 1.则证明middle点是最大值
            if(nums[middle] > nums[middle + 1]){
                return nums[middle + 1];
            }
            //此时如果middle - 1 > middle ，证明middle - 1是最大值点
            if(nums[middle - 1] > nums[middle]){
                return nums[middle];
            }
            //nums[0] < nums[middle]，此时证明middle点还未到最大值点
            if(nums[0] < nums[middle]){
                left = middle + 1;
            }else {
                right = middle - 1;
            }
        }
        return -1;



    }
}
