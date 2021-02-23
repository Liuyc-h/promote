package com.bj58.finance.platform.promote.algorithm.again;

/***
 *  给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * ***/
public class Solution59 {

    public int[][] generateMatrix(int n){
        int[][] result = new int[n][n];
        //上下左右
        int lower = 0;
        int upper = n -1;

        int left = 0;
        int right = n - 1;
        //定义一个计数器
        int count = 0;
        //定义下下标索引
        int i = 0,j = 0;

        while(true){

            while(j <= right){
                count ++;
                result[i][j] = count;
                j ++;
            }
            j--;
            lower ++;
            if(count >= n * n){
                break;
            }
            i = lower;

            while(i <= upper){
                count ++;
                result[i][j] = count;
                i ++;
            }
            i--;
            right --;
            if(count >= n * n){
                break;
            }
            j = right;
            while(j >= left){
                count ++;
                result[i][j] = count;
                j --;
            }
            j ++;
            upper --;
            if(count >= n * n){
                break;
            }
            i = upper;
            while(i >= lower){
                count ++;
                result[i][j] = count;
                i --;
            }
            i++;
            left ++;

            if(count >= n * n){
                break;
            }
            j = left;

        }
        return result;


    }


}
