package com.bj58.finance.platform.promote.utils;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int middle = (left + right) / 2;

            if(nums[middle] == target){
                return middle;
            }else if(nums[middle] > target){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {

        int[] array = new int[]{1,3,5,6};

        System.out.println(new Solution().searchInsert(array,7));

    }
}
