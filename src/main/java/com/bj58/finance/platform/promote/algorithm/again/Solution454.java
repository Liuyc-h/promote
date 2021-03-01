package com.bj58.finance.platform.promote.algorithm.again;

import java.util.HashMap;
import java.util.Map;

/**
 *  给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/

public class Solution454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D){
        //先定义一个map
        Map<Integer,Integer> firstMap = new HashMap<>();

        for(int i = 0; i < A.length; i++){

            for(int j = 0; j < B.length; j++){

                int sum = A[i] + B[j];
                int count = firstMap.getOrDefault(sum,0);
                count = count + 1;
                firstMap.put(sum,count);
            }
        }
        //结果
        int result = 0;
        for(int i= 0; i< C.length; i++){
            for(int j = 0; j < D.length; j++){

                int sum = C[i] + D[j];
                if(firstMap.containsKey(-sum)){
                    result = result + firstMap.get(-sum);
                }
            }
        }
        return result;


    }
}