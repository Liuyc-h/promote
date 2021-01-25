package com.bj58.finance.platform.promote.algorithm.daily.array;

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
public class Solution4_寻找两个正序数组的中位数 {
    //
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //nums1的长度
        int lengthNums1 = nums1.length;
        //nums2的长度
        int lengthNums2 = nums2.length;
        //中位数的索引数
        int firstIndex = (lengthNums1 + lengthNums2 - 1) / 2;
        int secondIndex = (lengthNums1 + lengthNums2) / 2;
        //直接找两个数
        int firstData = 0 ;
        int secondData = 0;
        int slideIndex = -1;
        //已经取数的标志
        Boolean flag1 = false;
        Boolean flag2 = false;

        int slide1Index = 0;
        int slide2Index = 0;
        //遍历取数
        while(slide1Index < lengthNums1  || slide2Index < lengthNums2 ){
            //nums1已经遍历完，nums2还未遍历完
            if(slide1Index == lengthNums1){
                slideIndex++;
                if(slideIndex == firstIndex){
                    firstData = nums2[slide2Index];
                    flag1 = true;
                }
                if(slideIndex == secondIndex){
                    secondData = nums2[slide2Index];
                    flag2 = true;
                }
                slide2Index ++;
                if(flag2 && flag1){
                    break;
                }
                continue;
            }
            //nums2遍历完，nums1还未遍历完
            if(slide2Index == lengthNums2){
                slideIndex++;
                if(slideIndex == firstIndex){
                    firstData = nums1[slide1Index];
                    flag1 = true;
                }
                if(slideIndex == secondIndex){
                    secondData = nums1[slide1Index];
                    flag2 = true;
                }
                slide1Index ++;
                if(flag2 && flag1){
                    break;
                }
                continue;
            }
            if(nums1[slide1Index] < nums2[slide2Index]){
                slideIndex ++;
                if(slideIndex == firstIndex){
                    firstData = nums1[slide1Index];
                    flag1 = true;
                }
                if(slideIndex == secondIndex){
                    secondData = nums1[slide1Index];
                    flag2 = true;
                }
                slide1Index ++;
            }else{
                slideIndex ++;
                if(slideIndex == firstIndex){
                    firstData = nums2[slide2Index];
                    flag1 = true;
                }
                if(slideIndex == secondIndex){
                    secondData = nums2[slide2Index];
                    flag2 = true;
                }
                slide2Index ++;
            }
            if(flag1 && flag2){
                break;
            }
        }
        double first = firstData;
        double second = secondData;

        return  (first + second) / 2;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3};
        int[] array1 = new int[]{2};

        System.out.println(new Solution4_寻找两个正序数组的中位数().findMedianSortedArrays(array1,array));
    }


}
