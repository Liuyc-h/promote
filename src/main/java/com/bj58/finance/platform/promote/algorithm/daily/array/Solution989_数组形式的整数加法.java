package com.bj58.finance.platform.promote.algorithm.daily.array;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * <p>
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 * <p>
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 * <p>
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 * <p>
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution989_数组形式的整数加法 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        //结果
        List<Integer> resultList = new ArrayList<>();
        //记录溢出位
        int overInt = 0;
        for (int i = A.length - 1; i >= 0; i--) {

            int remaind = K % 10;
            int sum = remaind + overInt + A[i];
            overInt = sum / 10;
            resultList.add(sum % 10);
            K = K / 10;
        }
        //K还没有加完得情况
        while (K > 0) {
            int sum = K % 10 + overInt;
            overInt = sum / 10;
            K = K / 10;
            resultList.add(sum % 10);
        }
        //加道最后溢出位还有值
        if (overInt > 0) {
            resultList.add(overInt);
        }
        //翻转这个List
        int left = 0;
        int right = resultList.size() - 1;
        while (left < right) {
            int temp = resultList.get(left);
            resultList.set(left, resultList.get(right));
            resultList.set(right, temp);
            left++;
            right--;
        }
        return resultList;
    }


    public static void main(String[] args) {
        List<Integer> resultList = new ArrayList<>();
        resultList.add(1);
        resultList.add(2);
        resultList.add(3);

        System.out.println(JSONObject.toJSONString(resultList));
    }
}
