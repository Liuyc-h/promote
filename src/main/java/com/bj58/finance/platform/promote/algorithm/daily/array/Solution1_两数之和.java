package com.bj58.finance.platform.promote.algorithm.daily.array;

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
public class Solution1_两数之和 {
    /**
     *  没啥要讲的，这个很好写
     *
     * **/
    public int[] twoSum(int[] nums, int target){
        if(nums == null || nums.length <= 1){
            return null;
        }
        //集合，key为值，value为下标索引
        Map<Integer,Integer> indexMap = new HashMap<>();
        for(int i =0; i< nums.length; i++){
            int another = target - nums[i];
            if(indexMap.containsKey(another)){
                return new int[]{indexMap.get(another),i};
            }
            indexMap.put(nums[i],i);
        }
        return null;
    }
}
