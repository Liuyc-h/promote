package com.bj58.finance.platform.promote.algorithm.classification.双指针;

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
    *  这道题的做法是先排序，再用双指针的做法来做
    *
    *  先对数组进行排序，Arrays.sort()来排序，排序空间复杂度0(n),时间复杂度0(n)
    *
    *  对数组进行遍历
    *   先确定一个数 索引值为i
    *   如果nums[i + 1] = nums[i],则跳过，因为最后得到的会重复
    *
    *   确定左边界   left = i + 1，右边界 right = nums.length - 1
    *   有三种情况
    *        sum = nums[left] + nums[left] + nums[right];
    *     sum == 0，将三个数加入集合，此时还需要去筛选重复的数据
    *        即在left < right的前提下，如果 nums[left] = nums[left + 1],left ++
    *          在left < right的前提下,如果nums[right] = nums[right - 1],right ++
    *      sum > 0的情况下，证明右边界点太大了，right --
    *      sum < 0的情况下，证明左边界点太大了，left ++
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


        List<List<Integer>> list = new Solution15().threeSum1(array);

        System.out.println(JSONObject.toJSONString(list));
    }

    /**
     *先进行排序，然后固定一个节点
     * 双指针从两端进行遍历
     * 空间复杂度为O(1)
     * 时间复杂度为O（n2）
     *
     * **/
    public List<List<Integer>> threeSum1(int[] nums){
        //先定义一个返回list
        List<List<Integer>> resultList = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return resultList;
        }
        //先进行排序
        Arrays.sort(nums);
        //首节点大于0，没结果了
        if(nums[0] > 0){
            return resultList;
        }
        int length = nums.length;

        for(int i = 0; i < length - 2; i++){
            //因为不能重复，所以当前值等于前一个值得时候，跳出不执行
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            //双指针滑动
            //左节点
            int left = i + 1;
            //右节点
            int right = length - 1;

            while(left < right){

                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> list = Arrays.asList(nums[i],nums[left],nums[right]);
                    resultList.add(list);
                    while(left < right && nums[left] == nums[left + 1]){
                        left ++;
                    }
                    while(left < right && nums[right] ==  nums[right - 1]){
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

}
