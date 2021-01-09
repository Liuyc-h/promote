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
public class Solution31_下一个排列 {

    public void nextPermutation(int[] nums){
        if(nums == null || nums.length <= 1){
            return;
        }
        int length = nums.length;
        //先从右到左遍历找到一个第一次出现降序的数据,找到这个点以后
        //则 i + 1 -> length - 1,这个区间是单调递减的
        int i = length - 2;
        while(i >= 0){
            if(nums[i] < nums[i+1]){
                break;
            }
            i--;
        }
        //如果存在的话，再从右到左找到第一个比i这个位置的数据大的值，然后交换，
        if(i >= 0){
            int j = length - 1;
            while(j > i && nums[j] <= nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        //i + 1 到length - 1翻转一下即可
        reverseArray(nums,i + 1,length - 1);
    }
    /**
     *  交换两个索引所在的值
     * **/
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    /***
     *  从指定的位置进行翻转
     * */
    private void reverseArray(int[] nums,int start,int end){
        int left = start;
        int right = end;
        while(left < right){
            swap(nums,left,right);
            left ++;
            right --;
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,6,5,4};
        new Solution31_下一个排列().nextPermutation(array);
        System.out.println(JSONObject.toJSONString(array));
    }
}
