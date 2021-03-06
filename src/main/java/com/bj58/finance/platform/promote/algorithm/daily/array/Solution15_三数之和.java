package com.bj58.finance.platform.promote.algorithm.daily.array;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 *给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * 通过次数394,904提交次数1,295,952
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution15_三数之和 {

    /**
     *  先排序，
     *  然后固定一个值，用左右指针做
     * **/
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return resultList;
        }
        //先进行排序
        Arrays.sort(nums);
        //第一个数大于0，就不需要往后判断了
        if(nums[0] > 0){
            return resultList;
        }

        for(int i =0; i < nums.length - 2 ; i++){
            //当i > 0，并且nums[i] == nums[i - 1]，则两者得到的肯定有重复的，
            //所以此时跳出
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            //左指针
            int left = i + 1;
            //右指针
            int right = nums.length - 1;
            while(left < right){
                //三数之和
                int sum = nums[i] + nums[left] + nums[right];
                //此时符合要求
                if(sum == 0){

                    List<Integer> result = Arrays.asList(nums[i],nums[left],nums[right]);
                    resultList.add(result);
                    //去除掉重复的
                    while(left < right  && nums[left] == nums[left+1]){
                          left ++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){
                        right --;
                    }
                    left ++;
                    right --;
                }else if (sum > 0){//sum > 0,right减小
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


        List<List<Integer>> list = new Solution15_三数之和().threeSum(array);

        System.out.println(JSONObject.toJSONString(list));
    }

}
