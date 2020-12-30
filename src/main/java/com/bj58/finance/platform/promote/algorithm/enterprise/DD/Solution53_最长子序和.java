package com.bj58.finance.platform.promote.algorithm.enterprise.DD;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution53_最长子序和 {

    /**
     *
     * **/
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
    /***
     *
     * 假设 nums 数组的长度是 nn，下标从 00 到 n - 1n−1。
     *
     * 我们用 a_ia
     * i
     * ​
     *   代表 nums[i]，用 f(i)f(i) 代表以第 ii 个数结尾的「连续子数组的最大和」，那么很显然我们要求的答案就是：
     *
     * \max_{0 \leq i \leq n - 1} \{ f(i) \}
     * 0≤i≤n−1
     * max
     * ​
     *  {f(i)}
     *
     * 因此我们只需要求出每个位置的 f(i)f(i)，然后返回 f 数组中的最大值即可。那么我们如何求 f(i)f(i) 呢？我们可以考虑 a_ia
     * i
     * ​
     *   单独成为一段还是加入 f(i - 1)f(i−1) 对应的那一段，这取决于 a_ia
     * i
     * ​
     *   和 f(i - 1) + a_if(i−1)+a
     * i
     * ​
     *  的大小，我们希望获得一个比较大的，于是可以写出这样的动态规划转移方程：
     *
     * f(i) = \max \{ f(i - 1) + a_i, a_i \}
     * f(i)=max{f(i−1)+a
     * i
     * ​
     *  ,a
     * i
     * ​
     *  }
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * ***/
    public int maxSubArray1(int[] nums){
        //动态规划数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];
        for(int i = 1; i< nums.length; i++){
            dp[i] = Math.max(nums[i] + dp[i-1],nums[i]);
            result = Math.max(dp[i],result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(new Solution53_最长子序和().maxSubArray1(array));
    }


}
