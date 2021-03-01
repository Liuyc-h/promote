package com.bj58.finance.platform.promote.algorithm.again;

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
public class Solution485 {

    public int findMaxConsecutiveOnes(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }
        //数组长度
        int length = nums.length;
        //1开始和结束得索引
        int startIndex = -1;
        int endIndex = -1;
        //结果
        int result = 0;
        for(int i = 0; i< length; i++){
            //初始赋值
            if(startIndex == -1 && nums[i] == 1){
                startIndex = i;
                endIndex = i;
                continue;
            }
            //未初始赋值，且当前值不是1，跳过
            if(startIndex == -1 && nums[i] != 1){
                continue;
            }
            //初始赋值已过，又连续得1出现
            if(startIndex != -1 && nums[i] == 1){
                endIndex = i;
                continue;
            }
            result = Math.max(endIndex - startIndex + 1,result);
            startIndex = -1;
            endIndex = -1;
        }
        return startIndex == -1 ? result : Math.max(result,endIndex - startIndex +1);
    }

    public int findMaxConsecutiveOnes1(int[] nums) {
        int maxCount = 0, count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }


    public static void main(String[] args) {
        int[] array = new int[]{1,1};

        System.out.println(new Solution485().findMaxConsecutiveOnes(array));
    }
}
