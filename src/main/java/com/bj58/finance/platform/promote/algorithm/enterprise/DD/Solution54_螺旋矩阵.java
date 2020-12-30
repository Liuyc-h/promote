package com.bj58.finance.platform.promote.algorithm.enterprise.DD;

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
 * 通过次数95,839提交次数228,148
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution54_螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        //结果List
        List<Integer> resultList = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return resultList;
        }
        //高度
        int zLength = matrix.length;
        //宽度
        int hLength = matrix[0].length;
        //上
        int top = zLength - 1;
        //下
        int down = 0;
        //左
        int left = 0;
        //右
        int right = hLength - 1;
        int count = 0;
        int i = 0,j=0;
        while(true){
            //从左到右
            while(j <= right){
                resultList.add(matrix[i][j]);
                j++;
                count++;
            }
            j--;
            down ++;
            if(count >= zLength * hLength){
                break;
            }
            i = down;
            while( i <= top){
                resultList.add(matrix[i][j]);
                i++;
                count++;
            }
            i--;
            right--;
            if(count >= zLength * hLength){
                break;
            }
            j = right;
            while(j >= left){
                resultList.add(matrix[i][j]);
                j--;
                count++;
            }
            j++;
            top --;
            if(count >= zLength * hLength){
                break;
            }
            i = top;
            while(i >= down){
                resultList.add(matrix[i][j]);
                i--;
                count++;
            }
            i++;
            left ++;
            if(count >= zLength * hLength){
                break;
            }
            j = left;
        }
        return resultList;
    }


    public static void main(String[] args) {

        int[][] array = new int[][]{{1, 2, 3},{4, 5, 6 },{7, 8, 9 }};

        System.out.println(JSONObject.toJSONString(new Solution54_螺旋矩阵().spiralOrder(array)));

    }
}
