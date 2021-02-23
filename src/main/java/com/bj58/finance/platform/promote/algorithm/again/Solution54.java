package com.bj58.finance.platform.promote.algorithm.again;


import com.alibaba.fastjson.JSONObject;
import com.bj58.finance.platform.promote.algorithm.daily.array.Solution54_螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 *  给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution54 {


    public List<Integer> spiralOrder(int[][] matrix){

        List<Integer> resultList = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return resultList;
        }
        //行的长度和列的长度
        int hLength = matrix.length;
        int lLength = matrix[0].length;
        //定义下四个变量和计数器上下左右
        int lower = 0;
        int upper = hLength - 1;

        int left = 0;
        int right = lLength - 1;
        int count = 0;

        int i = 0,j = 0;

        while(true){

            while( j <= right){
                resultList.add(matrix[i][j]);
                j ++;
                count ++;
            }
            j --;
            lower ++;
            if(count >= hLength * lLength){
                break;
            }
            i = lower;
            while(i <= upper){
                resultList.add(matrix[i][j]);
                i ++;
                count ++;
            }
            i--;
            right --;
            if(count >= hLength * lLength){
                break;
            }
            j = right;
            while(j >= left){
                resultList.add(matrix[i][j]);
                j --;
                count ++;
            }
            j ++;
            upper --;
            if(count >= hLength * lLength){
                break;
            }
            i = upper;
            while (i >= lower) {
                resultList.add(matrix[i][j]);
                i --;
                count ++;
            }
            i ++;
            left ++;

            if(count >= hLength * lLength){
                break;
            }
            j = left;
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3 },{ 4, 5, 6 },{7, 8, 9 }};

        List<Integer> resultList = new Solution54().spiralOrder(array);

        System.out.println(JSONObject.toJSONString(resultList));
    }


}
