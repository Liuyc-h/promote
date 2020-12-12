package com.bj58.finance.platform.promote.algorithm.daily.array;

import com.alibaba.fastjson.JSONObject;

/**
 *  实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution31 {

    public void nextPermutation(int[] nums){

        int length = nums.length;
        int i = length - 2;
        //从右向左遍历，先找出第一个出现降序得。也就是第一个出现  nums[i] >= nums[i + 1]
        // 也就是从
        while(i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        //存在的情况下，再找出比这个元素小的最
        if(i >= 0){
            int j = length - 1;
            while(j > i && nums[i] >= nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        //整体翻转
        reverseArray(nums,i + 1,length - 1);
    }
    //交换元素
    private void swap(int[] array,int swap1,int swap2){
        int temp = array[swap1];
        array[swap1] = array[swap2];
        array[swap2] = temp;
    }
    //反转数组
    private void reverseArray(int[] array,int beginIndex,int endIndex){

        while(beginIndex < endIndex){
            swap(array,beginIndex,endIndex);
            beginIndex++;
            endIndex --;
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{1,2,2,1};
        new Solution31().nextPermutation(array);

        System.out.println(JSONObject.toJSONString(array));
    }

    public void nextPermutation1(int[] nums){

    }
}
