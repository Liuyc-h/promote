package com.bj58.finance.platform.promote.algorithm.again;

/***
 *给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * **/
public class Solution48 {

    public void rotate(int[][] matrix) {

        if (matrix == null || matrix.length <= 1) {
            return;
        }
        //数组的大小   n * n
        int length = matrix.length;
        //上下指针
        int down = 0;
        int top = length - 1;
        //左右指针
        int right = length - 1;
        int left = 0;

        while (down < top) {

            for (int i = left; i < right; i++) {
                //需要交换的四个数据
                int first = matrix[down][i];
                int second = matrix[i][top];
                int third = matrix[top][length - 1 - i];
                int four = matrix[length - 1 - i][down];
                //进行交换
                matrix[down][i] = four;
                matrix[i][top] = first;
                matrix[top][length - 1 - i] = second;
                matrix[length - 1 - i][down] = third;
            }
            down++;
            top--;
            left++;
            right--;
        }
    }
}
