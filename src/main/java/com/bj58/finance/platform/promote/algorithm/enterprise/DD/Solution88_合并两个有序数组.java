package com.bj58.finance.platform.promote.algorithm.enterprise.DD;

import com.alibaba.fastjson.JSONObject;

/**
 *  给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明：
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例：
 *
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出：[1,2,2,3,5,6]
 *  
 *
 * 提示：
 *
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution88_合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums2 == null){
            return;
        }
        //翻转数组1和数组2,从后往前遍历
        reverseArray(nums1);
        reverseArray(nums2);
        int length = nums1.length;
        //定义滑窗
        int slide2 = 0;
        int slide1 = length - m;
        //定义一个索引插入位
        int index = 0;
        while(slide2 < n || slide1 < length){

            if(slide1 >= length){
                nums1[index ++] = nums2[slide2++];
                continue;
            }
            if(slide2 >= n){
                nums1[index ++] = nums1[slide1++];
                continue;
            }

            if(slide2 < n && nums2[slide2] >= nums1[slide1] ){
                nums1[index ++] = nums2[slide2++];
                continue;
            }
            //
            if(slide2 < n && nums2[slide2] < nums1[slide1]){
                nums1[index ++] = nums1[slide1 ++];
                continue;
            }
            if(slide1 < length && nums1[slide1] >= nums2[slide2] ){
                nums1[index ++] = nums1[slide1++];
                continue;
            }
            //
            if(slide1 < length && nums1[slide1] < nums2[slide2]){
                nums1[index ++] = nums2[slide2 ++];
                continue;
            }
        }
        reverseArray(nums1);
    }

    //翻转数组
    private void reverseArray(int[] nums){
        if(nums == null || nums.length <= 1){
            return;
        }
        int length = nums.length;

        int index = 0;
        while(index < length / 2){
             //备用
            int temp = nums[index];
            nums[index] = nums[length - 1 - index];
            nums[length - 1 - index] = temp;
            index ++;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};

        new Solution88_合并两个有序数组().merge(nums1,3,nums2,3);
        System.out.println(JSONObject.toJSONString(nums1));
    }
}
