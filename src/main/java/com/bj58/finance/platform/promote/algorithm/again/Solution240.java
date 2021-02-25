package com.bj58.finance.platform.promote.algorithm.again;

/**
 * /***
 *  * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *  *
 *  * 每行的元素从左到右升序排列。
 *  * 每列的元素从上到下升序排列。
 *  *  
 *  *
 *  * 示例 1：
 *  *
 *  *
 *  * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 *  * 输出：true
 *  * 示例 2：
 *  *
 *  *
 *  * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 *  * 输出：false
 *  *  
 *  *
 *  * 提示：
 *  *
 *  * m == matrix.length
 *  * n == matrix[i].length
 *  * 1 <= n, m <= 300
 *  * -109 <= matix[i][j] <= 109
 *  * 每行的所有元素从左到右升序排列
 *  * 每列的所有元素从上到下升序排列
 *  * -109 <= target <= 109
 *  *
 *  * 来源：力扣（LeetCode）
 *  * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 *  * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  *
 *  * **/
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0){
            return false;
        }
        //行数
        int hLength = matrix.length;
        //列数
        int lLength = matrix[0].length;
        //纵坐标，横坐标
        int i = 0;
        int j =  lLength - 1;

        while(i < hLength && j >= 0){
            //等于的化直接返回true
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] < target){//小于的话，i向右移
                i++;
            }else{//大于的话j向左移
                j --;
            }
        }
        return false;

    }

}
