package com.bj58.finance.platform.promote.algorithm.daily.array;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.converter.json.GsonBuilderUtils;

/**
 *  给定一个 n × n 的二维矩阵表示一个图像。
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
 * **/
public class Solution48 {

    public void rotate(int[][] matrix) {

        //n * n矩阵，所以长度和高度都是n
        int length = matrix.length;
        //左边界
        int left = 0;
        //右边界
        int right = length - 1;
        //原横坐标和纵坐标互换，原纵坐标和新横坐标相加等于length - 1
        while(left < right){

            for(int i = left; i < right; i++){

                //找出四个需要互换的坐标
                int firstChange = matrix[left][i] ;
                int secondChange =   matrix[i][length - 1 - left];
                int thirdChange = matrix[length - 1- left][length - 1 - i];
                int fourChange = matrix[length - 1 - i ][left];

                matrix[left][i] = fourChange;
                matrix[i][length - 1 - left] = firstChange;
                matrix[length - 1- left][length - 1 - i] = secondChange;
                matrix[length - 1 - i ][left] = thirdChange;
            }
            left ++;
            right --;
        }
    }

    public static void main(String[] args) {

        int[][] array = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        new Solution48().rotate(array);
        System.out.println(JSONObject.toJSONString(array));



    }
}
