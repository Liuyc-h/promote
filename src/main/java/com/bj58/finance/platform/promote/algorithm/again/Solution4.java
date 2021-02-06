package com.bj58.finance.platform.promote.algorithm.again;

/***
 *  给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution4 {
    //先合并为一个数组，然后再求中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //数组一二的长度
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        //合并的数组
        int[] result = new int[nums1Length + nums2Length];
        //定义一下滑动索引
        int nums1Index = 0;
        int nums2Index = 0;

        for(int i =0; i< result.length; i++){

            //数组1已经排完
            if(nums1Index >= nums1Length ){
                result[i] = nums2[nums2Index++];
                continue;
            }
            //数组2已经排完
            if(nums2Index >= nums2Length ){
                result[i] = nums1[nums1Index++];
                continue;
            }
            //两个还没一个排完的情况下
            if(nums1[nums1Index] > nums2[nums2Index]){
                result[i] = nums2[nums2Index ++];
            }else{
                result[i] = nums1[nums1Index++];
            }
        }

        double num1 = result[result.length / 2];
        double num2 = result[(result.length - 1) / 2];

        return (num1 + num2) / 2;



    }
}
