package com.bj58.finance.platform.promote.algorithm.classification.动态规划;


/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
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
 * **/
public class Solution64_最小路径和 {


    public int minPathSum(int[][] grid) {
        //行数
        int zLength = grid.length;
        //列数
        int hLength = grid[0].length;

        return dp(grid,zLength - 1,hLength - 1);
    }
    /**
     *  动态规划的方法
     * */
    private int dp(int[][] grid,int zLength,int hLength){
        if(zLength == 0 && hLength == 0){
            return grid[0][0];
        }
        // 如果索引出界，返回一个很大的值，
        // 保证在取 min 的时候不会被取到
        if (zLength < 0 || hLength < 0) {
            return Integer.MAX_VALUE;
        }
        // 左边和上面的最小路径和加上 grid[i][j]
        // 就是到达 (i, j) 的最小路径和
        return Math.min(
                dp(grid, zLength - 1, hLength),
                dp(grid, zLength, hLength - 1)
        ) + grid[zLength][hLength];
    }

    public int minPathSum1(int[][] grid){
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        //定义一个跟原二维数组一样的数组
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        //先填充一些数据，第一列和第一行
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        //dp[i][j] 是由grid[i - 1][j]向上走一步或者grid[i][j-1]向右一步走过去的
        //所以dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i][j];
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }
}
