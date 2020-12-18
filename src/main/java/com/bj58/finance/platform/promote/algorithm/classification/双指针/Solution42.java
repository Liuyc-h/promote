package com.bj58.finance.platform.promote.algorithm.classification.双指针;

/**
 *给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
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
public class Solution42 {
    /***
     *  这个解法的思路是。
     *  先找出最高的那个柱子，然后从最高的向两边发散
     *    找出两边的最高的，然后向两边扩散就行
     * */
    public int trap(int[] height) {

        if(height == null || height.length <= 1){
            return 0;
        }
        //最高的索引
        int maxIndex = 0;
        for(int i = 1; i< height.length; i++){
            if(height[i] > height[maxIndex]){
                maxIndex = i;
            }
        }

        int capital = 0;
        //左边的最大值
        int leftMaxIndex = maxIndex;
        while(leftMaxIndex > 1){
            int leftIndex = 0;
            for(int i = 1; i < leftMaxIndex; i++){
                if(height[leftIndex] < height[i]){
                    leftIndex = i;
                }
            }
            for(int i = leftIndex + 1; i < leftMaxIndex;i++){
                capital = capital + height[leftIndex]  - height[i];
            }
            leftMaxIndex = leftIndex;
        }
        //右边的最大值
        int rightMaxIndex = maxIndex;
        while(rightMaxIndex  < height.length - 1){
            int rightIndex = rightMaxIndex + 1;
            for(int i = rightMaxIndex + 2; i < height.length; i++){
                if(height[rightIndex] < height[i]){
                    rightIndex = i;
                }
            }
            for(int i = rightMaxIndex + 1; i < rightIndex;i++){
                capital = capital + height[rightIndex]  - height[i];
            }
            rightMaxIndex = rightIndex;
        }
        return capital;
    }

    /***
     * 双指针
     * left = 0，right = length - 1
     * left_max   right_max
     *   left < right 的情况下开始循环
     *      1、height[left] < height[right],此时右边兜底，左边开始往上遍历，此时会有两种情况
     *         a、left_max <= height[left]，说明此时左边是单调递增的,此时更新left_max值，
     *         b、left_max > height[left],此时可以存水，存的水 = left_max - height[left]
     *     2、height[left] >= height[right],此时左边兜底，右边开始往上遍历，此时会有两种情况
     *        a、right_max <= height[right]，说明此时右边是单调递增的,此时更新right_max值，
     *        b、right_max > height[right],此时可以存水，存的水 = right_max - height[right]
     *
     *
     * */
    public int trap1(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            //先从小的开始走，小的决定着下限
            if (height[left] < height[right]) {
                //如果height[left]  > left_max,证明从左到右一直在增长
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {//height[left]  <= left_max，开始加，因为有right兜底
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                //如果height[right]  >= right_max,证明从右到左一直在增长
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {//如果height[right]  < right_max,开始加减，因为有left兜底
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] array = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(new Solution42().trap1(array));

    }
}
