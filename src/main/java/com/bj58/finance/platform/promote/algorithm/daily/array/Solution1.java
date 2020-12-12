package com.bj58.finance.platform.promote.algorithm.daily.array;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashMap;
import java.util.Map;

/***
 *  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 通过次数1,112,291提交次数2,285,904
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class Solution1 {

    /**
     *   hash只能算出一组
     *
     *   O（n)的时间复杂度，O（n）的空间复杂度
     * */
    public int[] twoSum(int[] nums, int target){

        Map<Integer,Integer> indexMap = new HashMap<>();

        for(int i = 0; i< nums.length;i++){
            int anotherInt = target - nums[i];
            if(indexMap.containsKey(anotherInt)){
                return new int[]{i,indexMap.get(anotherInt)};
            }
            indexMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("NO TWO DATA SUM IS TARGET!");
    }

    public static void main(String[] args) throws JsonProcessingException {

        int[] array = new int[]{2, 7, 11, 15};

        int[] arrayIndex = new Solution1().twoSum(array,9);

        System.out.println(JSONObject.toJSONString(arrayIndex));

    }

}
