package com.bj58.finance.platform.promote.algorithm.daily.array;

/**
 *数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 *
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 *  示例 2：
 *
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 *  
 *
 * 提示：
 *
 * cost 的长度范围是 [2, 1000]。
 * cost[i] 将会是一个整型数据，范围为 [0, 999] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * ***/
public class Solution746_使用最小花费爬楼梯 {

    public int minCostClimbingStairs(int[] cost) {
        //这几种情况都特殊处理
        if(cost == null || cost.length == 0){
            return 0;
        }
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            int goOne = dp[i - 1] + cost[i - 1];
            int goTwo = dp[i - 2] + cost[i - 2];

            dp[i] = Math.min(goOne,goTwo);
        }
        return dp[n];

    }

    public int minCostClimbingStairs1(int[] cost) {
        //这几种情况都特殊处理
        if(cost == null || cost.length == 0){
            return 0;
        }
        int n = cost.length;
         int prev = 0;
         int curr = 0;
        for(int i = 2; i <= n; i++){
            int goOne = curr + cost[i - 1];
            int goTwo = prev + cost[i - 2];
            prev = curr;
            curr = Math.min(goOne,goTwo);
        }
        return curr;

    }
}
