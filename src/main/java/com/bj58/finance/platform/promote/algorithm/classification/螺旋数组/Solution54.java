package com.bj58.finance.platform.promote.algorithm.classification.螺旋数组;

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
public class Solution54 {

    /**
     *  定义四个上下左右的节点，依次遍历
     * **/
    public List<Integer> spiralOrder(int[][] matrix) {

        if(matrix == null || matrix.length <= 0){
            return new ArrayList<>();
        }
        //结果List
        List<Integer> resultList = new ArrayList<>();
        //一维数组的个数
        int length = matrix.length;
        //一维数组的长度
        int size = matrix[0].length;
        //起始点
        int start = 0;
        //结束点
        int end = length - 1;
        //左起点
        int left = 0;
        //右起点
        int right = size - 1;

        int count = 0;

        int i =0,j=0;
        while(true){


            while(j <= right){
                resultList.add(matrix[i][j]);
                j++;
                count ++;
            }
            j--;
            start ++;
            i = start;
            if(count >= size * length ){
                break;
            }

            while( i <= end){
                resultList.add(matrix[i][j]);
                i++;
                count ++;
            }
            i--;
            right --;
            j = right;
            if(count >= size * length ){
                break;
            }

            while(j >= left){
                resultList.add(matrix[i][j]);
                j--;
                count ++;
            }
            j++;
            end --;
            i = end;
            if(count >= size * length ){
                break;
            }
            while(i >= start){
                resultList.add(matrix[i][j]);
                i--;
                count ++;
            }
            i++;
            left ++;
            j = left;
            if(count >= size * length ){
                break;
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3 },{ 4, 5, 6 },{7, 8, 9 }};

        List<Integer> resultList = new Solution54().spiralOrder(array);

        System.out.println(JSONObject.toJSONString(resultList));
    }
}
