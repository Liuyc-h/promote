package com.bj58.finance.platform.promote.algorithm.daily.array;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution18_四数之和 {

    /**
     *  和三数之和一样，先排序，然后固定两个值
     * **/
    public List<List<Integer>> fourSum(int[] nums, int target){

        List<List<Integer>> resultList = new ArrayList<>();
        if(nums == null || nums.length < 4){
            return resultList;
        }
        //排序
        Arrays.sort(nums);
        for(int i = 0; i< nums.length - 3; i++){
            //去除掉重复的
            if( i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j< nums.length - 2; j++){
                //去掉重复的
                if( j > (i + 1) && nums[j] == nums[j - 1]){
                    continue;
                }
                //左指针
                int left = j + 1;
                //右指针
                int right = nums.length - 1;
                while(left < right){
                    //四数之和
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(target == sum){
                        List<Integer> result = Arrays.asList(nums[i],nums[j],nums[left],nums[right]);
                        resultList.add(result);
                        while(left < right && nums[left] == nums[left + 1]){
                            left ++;
                        }
                        while(left < right && nums[right] == nums[right - 1]){
                            right --;
                        }
                        left ++;
                        right --;
                    }else if(target > sum){
                        left ++;
                    }else{
                        right --;
                    }
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
//        int[] array = new int[]{-1,0,1,2,-1,-4};
        int[] array = new int[]{0,0,0,0};

        System.out.println(JSONObject.toJSONString(new Solution18_四数之和().fourSum(array,0)));
    }
}
