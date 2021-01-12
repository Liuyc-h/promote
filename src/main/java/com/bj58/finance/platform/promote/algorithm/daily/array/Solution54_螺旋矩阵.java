package com.bj58.finance.platform.promote.algorithm.daily.array;

import com.alibaba.fastjson.JSONObject;

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
public class Solution54_螺旋矩阵 {

    /**
     *  先定义上下左右四个
     * **/
    public List<Integer> spiralOrder(int[][] matrix) {
        //结果List
        List<Integer> resultList = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return resultList;
        }
        //行数
        int hLength = matrix.length;
        //列数
        int lLength = matrix[0].length;
        //定义一个计数器
        int count = 0;
        //左右
        int right= lLength - 1;
        int left = 0;
        //上下
        int up = 0;
        int down = hLength - 1;
        int i= 0,j =0;
        while(true){

            while(j <= right){
                resultList.add(matrix[i][j]);
                count++;
                j++;
            }
            j--;
            up ++;
            if(count >= hLength * lLength){
                break;
            }
            i = up;
            while(i <= down){
                resultList.add(matrix[i][j]);
                count++;
                i++;
            }
            i--;
            right --;
            if(count >= hLength * lLength){
                break;
            }
            j = right;
            while(j >= left){
                resultList.add(matrix[i][j]);
                count++;
                j--;
            }
            j++;
            down --;
            if(count >= hLength * lLength){
                break;
            }
            i = down;
            while(i >= up){
                resultList.add(matrix[i][j]);
                count++;
                i--;
            }
            i++;
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

        List<Integer> resultList = new Solution54_螺旋矩阵().spiralOrder(array);

        System.out.println(JSONObject.toJSONString(resultList));
    }
}
