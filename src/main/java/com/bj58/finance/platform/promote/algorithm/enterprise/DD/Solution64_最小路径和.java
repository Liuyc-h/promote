package com.bj58.finance.platform.promote.algorithm.enterprise.DD;

/**
 *  给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *  
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * **/
public class Solution64_最小路径和 {

    public int minPathSum(int[][] grid) {

        if(grid == null || grid.length == 0){
            return 0;
        }
        //行数
        int hLength = grid.length;
        //列数
        int lLength = grid[0].length;

        int[][] dp = new int[hLength][lLength];
        dp[0][0] = grid[0][0];
        //两个边的无法选择，所以只能是相加
        for(int i = 1; i< hLength; i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for(int j = 1; j < lLength; j ++){
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for(int i = 1; i< hLength; i++){
            for(int j = 0; j < lLength; j++){
                dp[i][j] = Math.min((dp[i-1][j] + grid[i][j]),(dp[i][j - 1] + grid[i][j]));
            }
        }
        return dp[hLength - 1][lLength - 1];
    }
}
