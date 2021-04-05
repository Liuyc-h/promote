package com.bj58.finance.platform.promote.algorithm.again.face;

/***
 *有一批隔板，其高度用数组表示，相邻两隔板之间距离均为1，隔板本身不占体积，问下了足够多的雨之后，隔板中最多能蓄多少水？
 * 输入：[3,2,5,4,6,2]    输出： 18
 * 解释：
 * 3和5之间蓄水 3x2 = 6
 * 5和6之间蓄水 5x2 = 10
 * 6和2之间蓄水 2x1  = 2
 * 图示：
 *                     |
 *           | #   # |
 *           | # | # |
 * | #   # | # | # |
 * | # | # | # | # | # |
 * | # | # | # | # | # |
 *
 *
 *
 * **/
public class Solution_face_1 {

    public int trap(int[] height){

        int result = 0;
        if(height == null || height.length <= 1){
            return result;
        }
        //双指针
        int left = 0;
        int right = height.length - 1;
        //左边和右边得最大值
        int left_max_index = 0;
        int right_max_index = height.length - 1;

        while(left < right){
            //右边小于左边
            if(height[right] < height[left]){
                if(height[right] <= height[right_max_index]){
                    result = result + height[right_max_index];
                }else{
                    result = result + height[right];
                    right_max_index = right;
                }
                right --;
            }else{
                if(height[left] <= height[left_max_index]){
                    result = result + height[left_max_index];
                }else{
                    result = result + height[left];
                    left_max_index = left;
                }
                left ++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,2,5,4,6,2};
//        int[] array = new int[]{3,3};

        System.out.println(new Solution_face_1().trap(array));
    }
}
