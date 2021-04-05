package com.bj58.finance.platform.promote.algorithm.again;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *  
 *
 * 提示：
 *
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * ***/
public class Solution_42 {

    public int trap(int[] height) {

        int result = 0;
        if(height == null || height.length <= 2){
            return result;
        }
        //双指针
        int left = 0;
        int right = height.length - 1;
        //两边得最大值
        int left_max = height[left];
        int right_max = height[right];

        while(left < right){
            // 左 < 右
            if(height[left] < height[right]){

                if(height[left] < left_max){
                    result = result + left_max - height[left];
                }else{
                    left_max = height[left];
                }
                left ++;
            }else{
                if(height[right] < right_max){
                    result = result + right_max - height[right];
                }else{
                    right_max = height[right];
                }
                right --;
            }

        }
        return result;
    }
}
