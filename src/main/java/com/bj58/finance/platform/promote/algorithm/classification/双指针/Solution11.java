package com.bj58.finance.platform.promote.algorithm.classification.双指针;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 * 示例 3：
 *
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 示例 4：
 *
 * 输入：height = [1,2,1]
 * 输出：2
 *  
 *
 * 提示：
 *
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution11 {
    /**
     *  暴力解法
     *  这种解法一般时间复杂度都是n的平方。不提倡
     *  双层遍历即可，
     *  一个从左边遍历，一个从右边遍历
     * **/
    public int maxArea(int[] height) {

        if(height == null || height.length <= 1){
            return 0;
        }

        int length = height.length;

        int capi = 0;

        for(int i = 0;i < length - 1;i++){

            for(int j = length - 1; j > i; j--){
                int left = height[i];
                int right = height[j];

                int currCapi = Math.min(left,right) * ( j - i);
                capi = Math.max(currCapi,capi);
            }
        }
        return capi;
    }
    /**
     *  双指针
     *  这道题的关键在于，怎么在用双指针的情况下遍历一遍就可以得到最优解，并且不漏情况
     *
     * 左节点left从0开始，右节点right从length - 1开始
     *  分三种情况
     *   1、height[left] > height[right]
     *      此时左节点大于右节点，如果挪动左节点，得到的值只能是小于等于 当前的值的
     *      所以挪动右节点，即right --，此时才有可能得到大于当前值的
     *   2、height[left] < height[right]
     *      此时左节点小于右节点，如果挪动右节点，得到的值只能是小于等于 当前的值的
     *      所以挪动左节点，即left++，此时才有可能得到大于当前值的
     *   3、height[left] = height[right]
     *      此时挪动那个节点都无所谓
     * */
    public int maxArea1(int[] height) {

        if(height == null || height.length <= 1){
            return 0;
        }
        //
        int length = height.length;
        //左指针
        int left = 0;
        //右指针
        int  right = length - 1;

        int capital = 0;

        while(left < right){

            int currCapi = Math.min(height[left],height[right]) * (right - left);
            capital = Math.max(currCapi,capital);
            if(height[left] > height[right]){
                right --;
            }else if(height[left] <= height[right]){
                left ++;
            }
        }
        return capital;
    }

}
