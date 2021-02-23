package com.bj58.finance.platform.promote.algorithm.again;


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
public class Solution88 {

    public void merge(int[] nums1, int m, int[] nums2, int n){
        if(nums2 == null || nums2.length == 0){
            return;
        }
        //长度相等
        if(nums1.length != (m + n)){
            return;
        }
        //数组1的总长度
        int length = nums1.length;

        int slide1 = m - 1;
        int slide2 = n - 1;

        int slide = length - 1;

        while(slide1 >= 0 || slide2 >= 0){
            //此时nums1已经排完，nums2还没有排完
            if(slide1 < 0){
                nums1[slide --] = nums2[slide2--];
                continue;
            }
            //nums2已经排完，此时跳出即可
            if(slide2 < 0){
                break;
            }
            if(nums2[slide2] > nums1[slide1]){
                nums1[slide --] = nums2[slide2--];
            }else{
                int temp = nums1[slide1];
                nums1[slide1] = nums1[slide];
                nums1[slide] = temp;
                slide --;
                slide1--;
            }
        }
    }
}
