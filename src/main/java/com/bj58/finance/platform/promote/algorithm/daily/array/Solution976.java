package com.bj58.finance.platform.promote.algorithm.daily.array;

import java.util.Arrays;

/**
 *给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1,2]
 * 输出：5
 * 示例 2：
 *
 * 输入：[1,2,1]
 * 输出：0
 * 示例 3：
 *
 * 输入：[3,2,3,4]
 * 输出：10
 * 示例 4：
 *
 * 输入：[3,6,2,3]
 * 输出：8
 *  
 *
 * 提示：
 *
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-perimeter-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution976 {

    public int largestPerimeter(int[] A) {
        //先排序
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; --i) {
            //如果一个循环中，最大的两个数  i-2和i-1的和都小于 i的话，再往前遍历的数据肯定都小于
            //如果i - 2 和i- 1的和大于 i的值的话，那么直接返回即可，因为这是最大的
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,4,18,3,8,4,4};


        System.out.println(new Solution976().largestPerimeter(array));
    }



}
