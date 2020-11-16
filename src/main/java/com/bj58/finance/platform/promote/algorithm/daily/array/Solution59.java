package com.bj58.finance.platform.promote.algorithm.daily.array;

/**
 *给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
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
 * */
public class Solution59 {

    public int[][] generateMatrix(int n) {

        if (n <= 0){
            return new int[][]{};
        }
        //上
        int up = 0;
        //下
        int under = n - 1;
        //左
        int left = 0;
        //右
        int right = n -1;

        int i= 0, j =0;

        int count = 1;
        int[][] resultArray = new int[n][n];

        while(true){

            while(j <= right){
                resultArray[i][j] = count;
                count ++;
                j++;
            }
            j--;
            up ++;
            i = up;
            if(count > n * n){
                break;
            }

            while(i <= under){
                resultArray[i][j] = count;
                count ++;
                i++;
            }
            i--;
            right --;
            j = right;
            if(count > n * n){
                break;
            }

            while(j >= left){
                resultArray[i][j] = count;
                count ++;
                j--;
            }
            j++;
            under --;
            i = under;
            if(count > n * n){
                break;
            }

            while(i >= up){
                resultArray[i][j] = count;
                count ++;
                i--;
            }
            i++;
            left ++;
            j = left;
            if(count > n * n){
                break;
            }
        }
        return resultArray;
    }
}
