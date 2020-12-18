package com.bj58.finance.platform.promote.algorithm.classification.搜索空间的缩减;

/**编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：

 每行的元素从左到右升序排列。
 每列的元素从上到下升序排列。
  

 示例 1：


 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 输出：true
 示例 2：


 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 输出：false
  

 提示：

 m == matrix.length
 n == matrix[i].length
 1 <= n, m <= 300
 -109 <= matix[i][j] <= 109
 每行的所有元素从左到右升序排列
 每列的所有元素从上到下升序排列
 -109 <= target <= 109

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。**
 * ***/
public class Solution240 {
    //缩减搜索域
    /***
     *  因为从左到右，从上到下都是递增的，所以从左边一列或者最底层一行的最大最小值开始
     *     大于target ，则行减小
     *     小于target ，则列增加
     *     等于的话，输出
     * **/
    public boolean searchMatrix(int[][] matrix, int target) {
        //层高
        int m = matrix.length;
        //每层的长度
        int n = matrix[0].length;

        int top = m - 1;
        int right = 0;
        //从 matrix[m-1][0]开始
        //因为这一列是最小的一列，所以从这一列开始遍历
        while (top >= 0 && right < n) {
            //大于的话，行减小
            if (matrix[top][right] > target) {
                top--;
            } else if (matrix[top][right] < target) {//小于的话，列增大
                right++;
            } else { // found it
                return true;
            }
        }
        return false;
    }

    //缩减搜索域
    public boolean searchMatrix1(int[][] matrix, int target) {
        //层高
        int m = matrix.length;
        //每层的长度
        int n = matrix[0].length;

        int top = 0;
        int right = n - 1;
        //从 matrix[0][n - 1]开始
        //因为这一列是最小的一行，所以从这一行开始遍历
        while (right >= 0 && top < m) {
            //大于的话，列减小
            if (matrix[top][right] > target) {
                right --;
            } else if (matrix[top][right] < target) {//小于的话，行增大
                top++;
            } else { // found it
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] array = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};

        System.out.println(new Solution240().searchMatrix1(array,20));

    }
}
