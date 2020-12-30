//package com.bj58.finance.platform.promote.algorithm.daily.array;
//
///**
// * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
// *
// *  
// *
// * 示例 1：
// *
// *
// * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// * 输出：6
// * 解释：最大矩形如上图所示。
// * 示例 2：
// *
// * 输入：matrix = []
// * 输出：0
// * 示例 3：
// *
// * 输入：matrix = [["0"]]
// * 输出：0
// * 示例 4：
// *
// * 输入：matrix = [["1"]]
// * 输出：1
// * 示例 5：
// *
// * 输入：matrix = [["0","0"]]
// * 输出：0
// *
// * 来源：力扣（LeetCode）
// * 链接：https://leetcode-cn.com/problems/maximal-rectangle
// * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
// *
// * **/
//public class Solution85 {
//
//    public int maximalRectangle(char[][] matrix) {
//        //为空则返回0
//        if(matrix == null || matrix.length == 0){
//            return 0;
//        }
//        //纵向长度
//        int m = matrix.length;
//        //横向长度
//        int n = matrix[0].length;
//
//        for(int i = 0; i< m; i++){
//
//            for(int j =0; j < n; j++){
//                 //不为1，跳出
//                if(matrix[i][j] != '1'){
//
//                }
//            }
//
//        }
//
//    }
//}
