package com.bj58.finance.platform.promote.algorithm.daily.array;

/***
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 有足够的空间（空间大小等于 m + n）来保存 nums2 中的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * nums1.length == m + n
 * nums2.length == n
 * -109 <= nums1[i], nums2[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * ***/
public class Solution88_合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if(nums2.length == 0){
            return;
        }
        //nums1的长度
        int length = nums1.length;
        int slide1Index = m - 1;
        int slide2Index = n - 1;

        for(int i = length - 1; i >= 0 ; i--){
            //两个都为-1，排完序了，跳出
            if(slide1Index < 0 && slide2Index < 0){
                break;
            }
            if(slide1Index < 0){//slide1Index < 0,nums1拍完了，nums2直接赋值
                nums1[i] = nums2[slide2Index];
                slide2Index --;
                continue;
            }
            //slide2Index < 0,nums2拍完了，nums1直接赋值
            if(slide2Index < 0){
                break;
            }
            //g根据大小排序
            if(nums1[slide1Index] > nums2[slide2Index]){
                swap(nums1,slide1Index,i);
                slide1Index --;
            }else{
                nums1[i] = nums2[slide2Index];
                slide2Index --;
            }
        }
    }

    private void swap(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};

        new Solution88_合并两个有序数组().merge(nums1,3,nums2,3);

    }
}
