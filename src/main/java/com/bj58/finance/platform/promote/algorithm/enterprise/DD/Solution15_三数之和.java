package com.bj58.finance.platform.promote.algorithm.enterprise.DD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution15_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return resultList;
        }
        Arrays.sort(nums);
        if(nums[0] > 0){
            return resultList;
        }
        //遍历
        for(int i = 0; i< nums.length - 2; i++ ){
            //前后相等，肯定会重复，去掉重复的
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;

            while(l < r){
                int sum = nums[i] + nums[r] + nums[l];

                if(sum == 0){
                    List<Integer> subResult = Arrays.asList(nums[i],nums[r],nums[l]);
                    resultList.add(subResult);

                    while(l < r && nums[l] == nums[l + 1]){
                        l ++;
                    }
                    while(l < r && nums[r] == nums[r + 1]){
                        r--;
                    }
                    l ++;
                    r--;
                }else if(sum > 0){
                    r--;
                }else{
                    l ++;
                }
            }
        }
        return resultList;
    }
}
