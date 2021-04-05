package com.bj58.finance.platform.promote.algorithm.again;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
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
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * ***/
public class Solution_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int slide1Index = m - 1;
        int slide2Index = n - 1;

        int index = m + n - 1;

        while(slide1Index >= 0 || slide2Index >= 0){
            //slide2Index 排完了，则证明整个数组已经排完了，推出
            if(slide2Index < 0){
                return;
            }
            //slide1Index 排完了，此时只需要排numns2即可
            if(slide1Index < 0){
               nums1[index -- ] = nums2[slide2Index --];
               continue;
            }
            //两个都没排完得情况下
            if(nums1[slide1Index] < nums2[slide2Index]){
                nums1[index -- ] = nums2[slide2Index --];
            }else{
                nums1[index -- ] = nums1[slide1Index --];
            }
        }

    }
}
