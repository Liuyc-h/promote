package com.bj58.finance.platform.promote.algorithm.again;

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

    public void nextPermutation(int[] nums) {

        if(nums == null || nums.length <= 1){
            return;
        }
        //数组长度
        int length = nums.length;

        int i = length - 2;
        while(i >= 0){
            //从左到右找出降序的第一个元素
            if(nums[i] < nums[i + 1]){
                break;
            }
            i--;
        }

        if(i >= 0){
            //找出第一个大于i的值
            int j = length - 1;
            while(j >=0 && nums[j] <= nums[i]){
                j--;
            }
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        reverse(nums,i + 1,length - 1);
    }
    /**
     * 翻转数组元素
     * **/
    private void reverse(int[] nums,int start,int end){

        while(start < end){

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2};
        new Solution31().nextPermutation(array);
    }
}
