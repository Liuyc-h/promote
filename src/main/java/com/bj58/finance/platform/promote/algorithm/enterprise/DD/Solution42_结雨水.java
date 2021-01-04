package com.bj58.finance.platform.promote.algorithm.enterprise.DD;

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
 * **/
public class Solution42_结雨水 {

    public int trap(int[] height) {
        if(height == null || height.length <= 2){
            return 0;
        }
        //左边界
        int left = 0;
        //右边界
        int right = height.length - 1;
        //左边的最大值
        int left_max = 0;
        //右边的最大值
        int right_max = 0;

        int result = 0;

        while(left < right){
             //height[left] > height[right],左比右高，右边先操作
            if(height[left] > height[right]){
                //大于等于right_max，还在上升
                if(height[right] >= right_max){
                    right_max = height[right];
                }else{//小于的话证明可以装水了，可定能装上，因为有height[left]在左边堵着
                    result = result + right_max - height[right];
                }
                right --;
            }else{
                if(height[left] >= left_max){
                    left_max = height[left];
                }else{
                    result = result + left_max - height[left];
                }
                left ++;
            }
        }
        return result;
    }
}
