package com.bj58.finance.platform.promote.algorithm.enterprise.DD;

import com.bj58.finance.platform.promote.algorithm.top_100.Solution4_寻找两个正序数组的中位数;

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
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Slolution4_寻找两个正序数组的中位数 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         //nums1数组的长度
        int num1Length = nums1.length;
        //nums2数组的长度
        int num2Length = nums2.length;
        //先把两个有序数组合并成一个有序数组
        int[] resultArray = new int[num1Length + num2Length];
        //数组1的滑动索引
        int slide1Index = 0;
        //数组2的滑动索引
        int slide2Index = 0;
        for(int i = 0; i < num1Length + num2Length; i++){
            //数组一已经排完，数组二还没排完,后面就直接排数组2
            if(slide1Index >= num1Length && slide2Index < num2Length){
                resultArray[i] = nums2[slide2Index];
                slide2Index ++;
                continue;
            }
            //数组二排完，数组一没有排完，后面就直接排数组1
            if(slide2Index >= num2Length && slide1Index < num1Length){
                resultArray[i] = nums1[slide1Index];
                slide1Index ++;
                continue;
            }
            //
            if(nums1[slide1Index] > nums2[slide2Index]){
                resultArray[i] = nums2[slide2Index];
                slide2Index ++;
            }else{
                resultArray[i] = nums1[slide1Index];
                slide1Index ++;
            }
        }
        //如果数组长度是奇数，直接取中位数
        if(resultArray.length % 2 != 0){
            int middIndex = resultArray.length / 2 ;
            return new Double(resultArray[middIndex]);
        }
        //如果数组长度是偶数，取中间两个数的和除以2
        int middle1Index = resultArray.length / 2  - 1;
        int middle2Index = resultArray.length / 2;
        return new Double(resultArray[middle1Index] + resultArray[middle2Index]) / 2;
    }


    public static void main(String[] args) {

        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};

        System.out.println(new Solution4_寻找两个正序数组的中位数().findMedianSortedArrays(nums1,nums2));
    }
}
