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
public class Solution18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        //特殊处理
        if(nums == null || nums.length < 4){
            return new ArrayList<>();
        }
        //结果数组
        List<List<Integer>> resultArray = new ArrayList<>();
        if(nums.length == 4 && (nums[0] + nums[1] + nums[2] + nums[3]) == target){

            List<Integer> currResult = Arrays.asList(nums[0],nums[1],nums[2],nums[3]);
            resultArray.add(currResult);
            return resultArray;
        }
        //先排序
        Arrays.sort(nums);

        int length = nums.length;

        for(int i = 0; i< length - 3; i++){
            if(i > 0 && nums[i] == nums[i -1]){
                continue;
            }

            for(int j = i+ 1; j < length - 2; j ++){
                if( j < length - 2 && j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                //第一个数
                int first = nums[i];
                //第二个数
                int second = nums[j];
                //前两个数的和
                int sum = first + second;
                //左端点
                int left = j + 1;
                //右端点
                int right = length - 1;
                while(left < right){
                    int sumFour = sum + nums[left] + nums[right];
                    if(sumFour == target){
                        List<Integer> currResult = Arrays.asList(nums[i],nums[j],nums[left],nums[right]);
                        resultArray.add(currResult);

                        while(left < right && nums[left] == nums[left + 1]){
                            left ++;
                        }
                        while(left < right && nums[right] == nums[right - 1]){
                            right --;
                        }
                        left ++;
                        right --;
                    }else if(sumFour > target){
                        right --;
                    }else{
                        left ++;
                    }
                }
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
//        int[] array = new int[]{-1,0,1,2,-1,-4};
        int[] array = new int[]{0,-1,-3,5,-5};

        System.out.println(JSONObject.toJSONString(new Solution18().fourSum(array,1)));
    }
}
