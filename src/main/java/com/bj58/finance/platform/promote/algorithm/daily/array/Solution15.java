package com.bj58.finance.platform.promote.algorithm.daily.array;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
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
 *
 * */
public class Solution15 {

    /**
     * 先进行排序
     * 遍历数组，i + 1 得值 等于 i的值的话，跳过i（不重复）
     * 以i为左界，left = i + 1，right = length - 1，双指针滑动
     * 如果等于0的话，加入， left = left + 1的值，跳一步
     *                    right = right -1 的值，跳一步
     *  大于0的话，right --；
     *  小于0的话，left ++
     *
     * **/
    public List<List<Integer>> threeSum(int[] nums){
        if(nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        if(nums[0] > 0){
            return new ArrayList<>();
        }
        //结果
        List<List<Integer>> resultList = new ArrayList<>();
        //数组长度
        int length = nums.length;
        for(int i = 0; i< length - 1; i++){

            if( i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            //左节点
            int left = i + 1;
            //右节点
            int right = length - 1;

            while(left < right){

                int sum = nums[i] + nums[left] + nums[right];
                //sum == 0
                if(sum == 0){
                    List<Integer> dataList = Arrays.asList(nums[i],nums[left],nums[right]);
                    resultList.add(dataList);

                    while(left < right && nums[left] == nums[left + 1]){
                        left ++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){
                        right --;
                    }
                    left ++;
                    right --;
                }else if(sum > 0){
                    right --;
                }else{
                    left ++;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) throws Exception{

        int[] array = new int[]{-1, 0, 1, 2, -1, -4};


        List<List<Integer>> list = new Solution15().threeSum(array);

        System.out.println(JSONObject.toJSONString(list));

    }
}
