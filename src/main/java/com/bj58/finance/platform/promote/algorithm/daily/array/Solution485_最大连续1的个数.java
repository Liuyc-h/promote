package com.bj58.finance.platform.promote.algorithm.daily.array;

/**
 *给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * 通过次数67,884提交次数119,095
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution485_最大连续1的个数 {

    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int result = 0;
        int startIndex = -1;
        for(int i = 0; i< nums.length; i++){
            //startIndex未赋值，nums[i] 为1
            if(nums[i] == 1 && startIndex == -1){
                startIndex = i;
                continue;
            }
            //是1得话跳出,上面得条件已经限制了startIndex 不为-1
            if(nums[i] == 1){
                continue;
            }
            //nums[i] == 0,startIndex 为-1
            if(startIndex == -1){
                continue;
            }
            result = Math.max(i - startIndex,result);
            startIndex = -1;
        }
        return startIndex == -1 ? result : Math.max(result,nums.length - startIndex);
    }
}
