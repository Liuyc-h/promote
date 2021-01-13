package com.bj58.finance.platform.promote.algorithm.daily.array;

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
public class Solution59_螺旋矩阵II {


    public int[][] generateMatrix(int n) {

        int[][] resultArray = new int[n][n];

        //上
        int upper = 0;
        //下
        int lower = n -1;
        //左
        int left = 0;
        //右
        int right = n - 1;

        int element = 1;
        int i =0,j =0;
        while(true){

            while (j <= right) {
                resultArray[i][j] = element;
                element ++;
                j++;
            }
            j--;
            upper = upper + 1;
            if(element > n * n){
                break;
            }
            i = upper;
            while(i <= lower){
                resultArray[i][j] = element;
                element ++;
                i++;
            }
            i --;
            right --;
            if(element > n * n){
                break;
            }
            j = right;
            while(j >= left){
                resultArray[i][j] = element;
                element++;
                j--;
            }
            j++;
            lower --;
            if(element > n * n){
                break;
            }
            i = lower;
            while(i >= upper){
                resultArray[i][j] = element;
                element++;
                i--;
            }
            i++;
            left ++;
            if(element > n * n){
                break;
            }
            j = left;
        }
        return resultArray;
    }
}
