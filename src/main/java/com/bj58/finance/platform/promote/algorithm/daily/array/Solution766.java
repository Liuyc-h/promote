package com.bj58.finance.platform.promote.algorithm.daily.array;

/***
 *给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 *
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出：true
 * 解释：
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True 。
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,2],[2,2]]
 * 输出：false
 * 解释：
 * 对角线 "[1, 2]" 上的元素不同。
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 20
 * 0 <= matrix[i][j] <= 99
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/toeplitz-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * **/
public class Solution766 {

    public boolean isToeplitzMatrix(int[][] matrix) {

        if(matrix == null || matrix.length == 0){
            return true;
        }
        //行和列的长度
        int hLength = matrix.length;
        int lLength = matrix[0].length;
        if(hLength == 1 || lLength == 1){
            return true;
        }
        //先确定第一列
        int hStart = 0;
        while( hStart < hLength){

            int i = hStart;
            int j = 0;
            int data = matrix[i][j];

            while(true){
                if(matrix[i][j] != data){
                    return false;
                }
                i ++;
                j ++;
                if(i >= hLength || j >=lLength ){
                    break;
                }
            }
            hStart ++;
        }
        //先确定第一列
        int lStart = 0;
        while( lStart < lLength){

            int i = 0;
            int j = lStart;
            int data = matrix[i][j];

            while(true){
                if(matrix[i][j] != data){
                    return false;
                }
                i ++;
                j ++;
                if(i >= hLength || j >=lLength ){
                    break;
                }
            }
            lStart++;
        }
        return true;
    }

    public boolean isToeplitzMatrix1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }



    public static void main(String[] args) {
        int[][] array = new int[][]{{57,54},{84,57}};

        System.out.println(new Solution766().isToeplitzMatrix(array));
    }


}
